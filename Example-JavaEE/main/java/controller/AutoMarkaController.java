package controller;

import model.AutoMarka;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by aantipin on 11/12/2016.
 */
@Path(value = "/service/autoMarka")
public class AutoMarkaController extends AbstractRestController<AutoMarka> {
    private static final Logger logger = LogManager.getLogger(AbstractRestController.class);

    @EJB
    private ServiceApi<AutoMarka> testService;
//    @Autowired
//    private AutoMarkaService autoMarkaService;


    @Override
    protected ServiceApi getService() {
        return testService;
    }
}
