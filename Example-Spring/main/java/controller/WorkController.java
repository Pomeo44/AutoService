package controller;

import model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.ServiceApi;
import service.api.WorkService;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/work")
public class WorkController extends AbstractRestController<Work>{

    @Autowired
    private WorkService workService;

    @Override
    protected ServiceApi getService() {
        return workService;
    }
}
