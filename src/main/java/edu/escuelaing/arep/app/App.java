package edu.escuelaing.arep.app;

import edu.escuelaing.arep.app.http.Server;
import edu.escuelaing.arep.app.micro.MicroSpring;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        String[] args1=new String[1];
        args1[0]="edu.escuelaing.arep.app.micro.HelloController";
        MicroSpring microSpring= new MicroSpring();
        microSpring.starts(args1);
        Server server = new Server(microSpring);
        server.start();
    }


}
