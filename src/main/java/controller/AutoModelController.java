package controller;

import model.AutoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.api.AutoModelService;
import service.api.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by aantipin on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/service/automodel")
public class AutoModelController extends AbstractRestController<AutoModel> {

    @Autowired
    private AutoModelService autoModelService;

    @Override
    protected ServiceApi getService() {
        return autoModelService;
    }
}
