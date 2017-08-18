package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by aantipin on 16/08/2017.
 */
@ApplicationScoped
@Path("/")
public class TestController {

    @GET
    @Path("hello")
    public String hello() {
        return "Hi from REST!";
    }
}
