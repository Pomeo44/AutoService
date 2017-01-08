package controller;

import model.AutoType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.api.AutoTypeService;
import service.api.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by aantipin on 15/11/2016.
 */
@RestController
@RequestMapping(value = "/service/autotype")
public class AutoTypeController extends AbstractRestController<AutoType>{

    @Autowired
    private AutoTypeService autoTypeService;

    @Override
    protected ServiceApi getService() {
        return autoTypeService;
    }
}
