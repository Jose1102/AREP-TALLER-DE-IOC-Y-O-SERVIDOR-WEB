package edu.escuelaing.arep.app.micro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class MicroSpring
{


    private Map<String,Method> lista= new HashMap<>();

    public void starts(String[] args) throws Exception {
        int contador=0;
        for (Method m : Class.forName(args[0]).getMethods()) {
            RequestMapping imprimir = m.getAnnotation(RequestMapping.class);
            if (imprimir!=null) {
                try {

                    lista.put(m.getAnnotation(RequestMapping.class).value(),m);
                    contador++;
                } catch (Throwable ex) {
                }
            }
        }

    }

    public  String invoke(String path) throws InvocationTargetException, IllegalAccessException {
        return lista.get(path).invoke(null).toString();
    }




}
