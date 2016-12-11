package controller;

import model.AutoMarka;
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
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by aantipin on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/service/automodel")
public class AutoModelController {

    private static final Logger logger = LogManager.getLogger(AutoModelController.class);

    @Autowired
    private AutoModelService autoModelService;

    @GetMapping(value= "/")
     public ResponseEntity<List<AutoModel>> getAll() {
        logger.info("Find All AutoModel");
        List<AutoModel> autoModels = autoModelService.getAll();
        if(autoModels.isEmpty()){
            logger.info("AutoMarka's empty");
            return new ResponseEntity<List<AutoModel>>(HttpStatus.NO_CONTENT);
        }
        logger.info("AutoModels size = " + autoModels.size());
        return new ResponseEntity<List<AutoModel>>(autoModels, HttpStatus.OK);
    }

    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoModel> getById(@PathVariable("id") Integer id) {
        logger.info("Find AutoModel with id" + id);
        AutoModel autoModel = autoModelService.findById(id);
        if (autoModel == null) {
            logger.error("AutoModel with id " + id + " already exist");
            return new ResponseEntity<AutoModel>(HttpStatus.NOT_FOUND);
        }
        logger.info("Find AutoModel with id" + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoModel>(autoModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody AutoModel autoModel, UriComponentsBuilder ucBuilder) {
        logger.info("Create AutoModel");
        try {
            autoModelService.add(autoModel);
        } catch (NonUniqueObject nonUniqueObject) {
            logger.error("AutoModel with name " + autoModel.getName() + " already exist", nonUniqueObject);
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        logger.info("Create AutoModel with name " + autoModel.getName() + " SUCCESSFULLY");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(autoModel.getAutoModelId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AutoModel> update(@PathVariable("id") Integer id, @RequestBody AutoModel autoModel) {
        logger.info("Updating AutoModel id = " + id);
        try {
            autoModelService.update(autoModel);
        } catch (NonExistObject nonExistObject) {
            logger.error("AutoModel with id " + id + " not found");
            return new ResponseEntity<AutoModel>(HttpStatus.NOT_FOUND);
        }
        logger.info("Updating AutoModel with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoModel>(autoModel, HttpStatus.OK);
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<AutoModel> delete(@PathVariable("id") Integer id) {
        logger.info("Deleting AutoModel with id " + id);
        try {
            autoModelService.deleteById(id);
        } catch (NonExistObject nonExistObject) {
            logger.error("Unable to delete. AutoModel with id " + id + " not found");
            return new ResponseEntity<AutoModel>(HttpStatus.NOT_FOUND);
        }
        logger.info("Deleting AutoModel with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoModel>(HttpStatus.NO_CONTENT);
    }
}
