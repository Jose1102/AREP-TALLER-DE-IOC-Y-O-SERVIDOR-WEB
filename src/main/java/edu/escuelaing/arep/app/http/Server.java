package edu.escuelaing.arep.app.http;

import edu.escuelaing.arep.app.micro.MicroSpring;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Server {
    private MicroSpring microSpring;
    private String mensaje;

    public Server(MicroSpring microSpring) {
        this.microSpring = microSpring;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        try {
            boolean running = true;
            while (running) {
                System.out.println("Entra");
                Socket clientSocket = null;
                try {
                    System.out.println("Listo para recibir ...");
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    System.err.println("Accept failed.");
                    System.exit(1);
                }

                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String inputLine, outputLine;

                Map<String, String> request = new HashMap<>();
                boolean requestLineReady = false;
                while ((inputLine = in.readLine()) != null) {
                    if (!requestLineReady) {
                        request.put("requestLine", inputLine);
                        requestLineReady = true;
                    } else {
                        String[] entry = inputLine.split(":");
                        if (entry.length > 1) {
                            request.put(entry[0], entry[1]);
                        }
                    }

                    //
                    if (!in.ready()) {break; }
                }
                if(request.get("requestLine")!=null){
                    Request req = new Request(request.get("requestLine"));
                    System.out.println("RequestLine: " + req);
                    if(req != null) {


                        outputLine = paginaPorDefecto();
                        URI theuri = req.getTheuri();
                        if (theuri.getPath().startsWith("/Apps")) {
                            String appuri= theuri.getPath().substring(5);
                            invokeApp(appuri,new PrintWriter(clientSocket.getOutputStream(), true));
                        } else {
                            getStaticResource(theuri.getPath(), out,clientSocket.getOutputStream());
                        }
                    }
                }

                in.close();
                out.close();
                clientSocket.close();
            }
        }catch (Throwable ex) {
        }
    }

    private String paginaPorDefecto() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Title of the document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hola Mundo</h1>\n" +
                "</body>\n" +
                "</html>\n";
    }



    private void invokeApp(String appuri, PrintWriter out) throws InvocationTargetException, IllegalAccessException {

        String header = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
        String methodresponse = microSpring.invoke(appuri);
        out.println(header + methodresponse);
    }



    private void getStaticResource(String path, PrintWriter out, OutputStream outputStream) {
        Path file = Paths.get(System.getProperty("user.dir")+"/src/main/resources/imagenes" + path);
        if (path.contains("html") || path.contains("js")|| path.contains("ico")) {
            try (InputStream in = Files.newInputStream(file);
                 BufferedReader reader
                         = new BufferedReader(new InputStreamReader(in))) {

                String header = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n";
                out.println(header);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                    System.out.println(line);
                }
            } catch (IOException ex) {
                System.out.println("Failed");
            }
        }
        else if (path.contains("png")){
            System.out.println("Entra a PNG");
            try{
                BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/src/main/resources/imagenes/messi.png"));
                ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
                DataOutputStream out1 = new DataOutputStream(outputStream);
                ImageIO.write(image, "PNG", ArrBytes);
                out1.writeBytes("HTTP/1.1 200 OK \r\n"
                        + "Content-Type: image/png \r\n"
                        + "\r\n");
                out1.write(ArrBytes.toByteArray());
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }

}