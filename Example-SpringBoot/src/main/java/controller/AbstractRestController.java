package controller;

import model.BaseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.api.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 08.01.2017.
 */
abstract public class AbstractRestController<T extends BaseEntity> {

    private static final Logger logger = LogManager.getLogger(AbstractRestController.class);

    @GetMapping(value= "/")
    public ResponseEntity<List<T>> getAll() {
        logger.info("Find All " + T.ENTITY_TYPE);
        Iterable<T> entitys = getService().getAll();
        if(entitys.()){
            logger.info(T.ENTITY_TYPE + " empty");
            return new ResponseEntity<List<T>>(HttpStatus.NO_CONTENT);
        }
        logger.info(T.ENTITY_TYPE + " size = " + entitys.size());
        return new ResponseEntity<List<T>>(entitys, HttpStatus.OK);
    }

    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getById(@PathVariable("id") Integer id) {
        logger.info("Find " + T.ENTITY_TYPE + " with id" + id);
        T entity = (T) getService().findById(id);
        if (entity == null) {
            logger.error(T.ENTITY_TYPE + " with id " + id + " already exist");
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
        logger.info("Find " + T.ENTITY_TYPE + " with id" + id + " SUCCESSFULLY");
        return new ResponseEntity<T>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody T entity, UriComponentsBuilder ucBuilder) {
        logger.info("Create " + T.ENTITY_TYPE);
        try {
            getService().add(entity);
        } catch (NonUniqueObject nonUniqueObject) {
            logger.error(T.ENTITY_TYPE + " with name " + entity.getName() + " already exist", nonUniqueObject);
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        logger.info("Create " + T.ENTITY_TYPE + " with name " + entity.getName() + " SUCCESSFULLY");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(entity.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<T> update(@PathVariable("id") Integer id, @RequestBody T entity) {
        logger.info("Updating " + T.ENTITY_TYPE + " id = " + id);
        try {
            getService().update(entity);
        } catch (NonExistObject nonExistObject) {
            logger.error(T.ENTITY_TYPE + " with id " + id + " not found");
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
        logger.info("Updating " + T.ENTITY_TYPE + " with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<T>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<T> delete(@PathVariable("id") Integer id) {
        logger.info("Deleting " + T.ENTITY_TYPE + " with id " + id);
        try {
            getService().deleteById(id);
        } catch (NonExistObject nonExistObject) {
            logger.error("Unable to delete. " + T.ENTITY_TYPE + " with id " + id + " not found");
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
        logger.info("Deleting " + T.ENTITY_TYPE + " with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<T>(HttpStatus.NO_CONTENT);
    }

    abstract protected ServiceApi getService();
}
