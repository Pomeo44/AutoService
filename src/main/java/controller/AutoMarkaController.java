package controller;

import model.AutoMarka;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.api.AutoMarkaService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by aantipin on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/service/automarka")
public class AutoMarkaController {

    private static final Logger logger = LogManager.getLogger(AutoMarkaController.class);

    @Autowired
    private AutoMarkaService autoMarkaService;

    @GetMapping(value= "/")
     public ResponseEntity<List<AutoMarka>> getAll() {
        logger.info("Find All AutoMarka");
        List<AutoMarka> autoMarkas = autoMarkaService.getAll();
        if(autoMarkas.isEmpty()){
            logger.info("AutoMarka's empty");
            return new ResponseEntity<List<AutoMarka>>(HttpStatus.NO_CONTENT);
        }
        logger.info("AutoMarkas size = " + autoMarkas.size());
        return new ResponseEntity<List<AutoMarka>>(autoMarkas, HttpStatus.OK);
    }

    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoMarka> getById(@PathVariable("id") Integer id) {
        logger.info("Find AutoMarka with id" + id);
        AutoMarka autoMarka = autoMarkaService.findById(id);
        if (autoMarka == null) {
            logger.error("AutoMarka with id " + id + " already exist");
            return new ResponseEntity<AutoMarka>(HttpStatus.NOT_FOUND);
        }
        logger.info("Find AutoMarka with id" + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoMarka>(autoMarka, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody AutoMarka autoMarka, UriComponentsBuilder ucBuilder) {
        logger.info("Create AutoMarka");
        try {
            autoMarkaService.add(autoMarka);
        } catch (NonUniqueObject nonUniqueObject) {
            logger.error("AutoMarka with name " + autoMarka.getName() + " already exist", nonUniqueObject);
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        logger.info("Create AutoMarka with name " + autoMarka.getName() + " SUCCESSFULLY");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(autoMarka.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AutoMarka> update(@PathVariable("id") Integer id, @RequestBody AutoMarka autoMarka) {
        logger.info("Updating AutoMarka id = " + id);
        try {
            autoMarkaService.update(autoMarka);
        } catch (NonExistObject nonExistObject) {
            logger.error("AutoMarka with id " + id + " not found");
            return new ResponseEntity<AutoMarka>(HttpStatus.NOT_FOUND);
        }
        logger.info("Updating AutoMarka with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoMarka>(autoMarka, HttpStatus.OK);
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<AutoMarka> delete(@PathVariable("id") Integer id) {
        logger.info("Deleting AutoMarka with id " + id);
        try {
            autoMarkaService.deleteById(id);
        } catch (NonExistObject nonExistObject) {
            logger.error("Unable to delete. AutoMarka with id " + id + " not found");
            return new ResponseEntity<AutoMarka>(HttpStatus.NOT_FOUND);
        }
        logger.info("Deleting AutoMarka with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<AutoMarka>(HttpStatus.NO_CONTENT);
    }
}
