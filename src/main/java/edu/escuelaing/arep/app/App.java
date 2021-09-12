package edu.escuelaing.arep.app;

import edu.escuelaing.arep.app.micro.HelloController;
import edu.escuelaing.arep.app.micro.RequestMapping;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList lista = new ArrayList();
        lista.add(new HelloController());
        procesar(lista);
        //System.out.println( "Hello World!" );
    }

    public static void procesar(ArrayList listALeer){

        try{
            for (Object o : listALeer){
                Method[] campos = o.getClass().getMethods();
                for (Method c : campos){
                    RequestMapping imprimir = c.getAnnotation(RequestMapping.class);
                    if (imprimir!=null){

                        System.out.println(c.invoke(o));

                    }

                }

            }

        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
