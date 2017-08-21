package controller;

import dao.TestService;
import model.AutoMarka;
import service.ServiceApi;
import service.exception.NonUniqueObject;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by aantipin on 16/08/2017.
 */
//@ApplicationScoped
@Path("/hello")
public class TestController {

    @EJB
    private ServiceApi<AutoMarka> testService;

    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        //List<AutoMarka> autoMarkas = testService.getAll();
        return "Hello Jersey";
    }

    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        //List<AutoMarka> autoMarkas = testService.getAll();
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        List<AutoMarka> autoMarkas = testService.getAll();
        AutoMarka autoMarka = testService.findById(1);
        Integer autoMarka2 = null;
        try {
            autoMarka2 = testService.add(null);
        } catch (NonUniqueObject nonUniqueObject) {
            nonUniqueObject.printStackTrace();
        }
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello Jersey size = " + autoMarkas.size() + "; " + autoMarka.getName() + ";" + autoMarka2 + "</body></h1>" + "</html> ";
    }
}
