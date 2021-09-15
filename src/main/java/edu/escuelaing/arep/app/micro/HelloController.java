package edu.escuelaing.arep.app.micro;

public class HelloController {

    @RequestMapping(value = "/")
    static public String index() {
        return "Greetings from micro Spring Boot!";
    }

    @RequestMapping(value = "/path")
    static public String path() {
        return "Hola ";
    }


}