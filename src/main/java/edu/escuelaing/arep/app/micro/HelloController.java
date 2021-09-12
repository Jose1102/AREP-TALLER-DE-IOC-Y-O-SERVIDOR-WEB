package edu.escuelaing.arep.app.micro;

public class HelloController {

    @RequestMapping(value = "/prueba")
    static public String index() {
        return "Greetings from micro Spring Boot!";
    }


}