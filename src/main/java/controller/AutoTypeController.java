package controller;

import model.AutoType;
import model.Master;
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

    @Autowired
    private AutoTypeService autoTypeService;

    @GetMapping(value= "/")
    @ResponseBody
    public ResponseEntity<List<AutoType>> getAll() {
        List<AutoType> autoTypes = autoTypeService.getAll();
        if(autoTypes.isEmpty()){
            return new ResponseEntity<List<AutoType>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AutoType>>(autoTypes, HttpStatus.OK);
    }

    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AutoType> getById(@PathVariable("id") Integer id) {
        AutoType autoType = autoTypeService.findById(id);
        if (autoType == null) {
            return new ResponseEntity<AutoType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AutoType>(autoType, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> add(@RequestBody AutoType autoType, UriComponentsBuilder ucBuilder) {
        try {
            autoTypeService.add(autoType);
        } catch (NonUniqueObject nonUniqueObject) {
            //System.out.println("A User with name " + autoType.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(autoType.getAutoTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<AutoType> update(@PathVariable("id") long id, @RequestBody AutoType autoType) {
        //System.out.println("Updating User " + id);

        try {
            autoTypeService.update(autoType);
        } catch (NonExistObject nonExistObject) {
            //System.out.println("User with id " + id + " not found");
            return new ResponseEntity<AutoType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AutoType>(autoType, HttpStatus.OK);
    }

    @DeleteMapping(value= "/{id}")
    @ResponseBody
    public ResponseEntity<AutoType> delete(@PathVariable("id") Integer id) {
        //System.out.println("Fetching & Deleting User with id " + id);

        try {
            autoTypeService.deleteById(id);
        } catch (NonExistObject nonExistObject) {
            //System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<AutoType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AutoType>(HttpStatus.NO_CONTENT);
    }
}
