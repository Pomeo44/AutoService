package controller;

import model.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.ServiceApi;
import service.api.WorkTypeService;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/workType")
public class WorkTypeController extends AbstractRestController<WorkType>{

    @Autowired
    private WorkTypeService workTypeService;

    @Override
    protected ServiceApi getService() {
        return workTypeService;
    }
}
