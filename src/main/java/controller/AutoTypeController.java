package controller;

import model.AutoType;
import model.Master;
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
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by aantipin on 15/11/2016.
 */
@RestController
@RequestMapping(value = "/service/autotype")
public class AutoTypeController {

    private static final Logger logger = LogManager.getLogger(AutoTypeController.class);

    @Autowired
    private AutoTypeService autoTypeService;

    @GetMapping(value= "/")
     public ResponseEntity<List<AutoType>> getAll() {
        logger.info("Find All AutoType");
        List<AutoType> autoTypes = autoTypeService.getAll();
        if(autoTypes.isEmpty()){
            logger.info("AutoTypes's empty");
            return new ResponseEntity<List<AutoType>>(HttpStatus.NO_CONTENT);
        }
        logger.info("AutoTypes size = " + autoTypes.size());
        return new ResponseEntity<List<AutoType>>(autoTypes, HttpStatus.OK);
    }

    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoType> getById(@PathVariable("id") Integer id) {
        logger.info("Find AutoType with id" + id);
        AutoType autoType = autoTypeService.findById(id);
        if (autoType == null) {
            logger.error("AutoType with id " + id + " already exist");
            return new ResponseEntity<AutoType>(HttpStatus.NOT_FOUND);
        }
        logger.info("Find AutoType with id" + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoType>(autoType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody AutoType autoType, UriComponentsBuilder ucBuilder) {
        logger.info("Create AutoType");
        try {
            autoTypeService.add(autoType);
        } catch (NonUniqueObject nonUniqueObject) {
            logger.error("AutoType with name " + autoType.getName() + " already exist", nonUniqueObject);
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        logger.info("Create AutoType with name " + autoType.getName() + " SUCCESSFULLY");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(autoType.getAutoTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AutoType> update(@PathVariable("id") Integer id, @RequestBody AutoType autoType) {
        logger.info("Updating AutoType id = " + id);
        try {
            autoTypeService.update(autoType);
        } catch (NonExistObject nonExistObject) {
            logger.error("AutoType with id " + id + " not found");
            return new ResponseEntity<AutoType>(HttpStatus.NOT_FOUND);
        }
        logger.info("Updating AutoType with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoType>(autoType, HttpStatus.OK);
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<AutoType> delete(@PathVariable("id") Integer id) {
        logger.info("Deleting AutoType with id " + id);
        try {
            autoTypeService.deleteById(id);
        } catch (NonExistObject nonExistObject) {
            logger.error("Unable to delete. AutoType with id " + id + " not found");
            return new ResponseEntity<AutoType>(HttpStatus.NOT_FOUND);
        }
        logger.info("Deleting AutoType with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoType>(HttpStatus.NO_CONTENT);
    }
}
