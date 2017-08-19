package controller;

import model.OwnerAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.OwnerAutoService;
import service.api.ServiceApi;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/ownerAuto")
public class OwnerAutoController extends AbstractRestController<OwnerAuto>{

    @Autowired
    private OwnerAutoService ownerAutoService;

    @Override
    protected ServiceApi getService() {
        return ownerAutoService;
    }
}
