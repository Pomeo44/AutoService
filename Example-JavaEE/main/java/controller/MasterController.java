package controller;

import model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.MasterService;
import service.api.ServiceApi;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/master")
public class MasterController extends AbstractRestController<Master>{

    @Autowired
    private MasterService masterServiceService;

    @Override
    protected ServiceApi getService() {
        return masterServiceService;
    }
}
