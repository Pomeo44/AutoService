package controller;

import model.BaseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * Created by Pomeo on 08.01.2017.
 */
abstract public class AbstractRestController<T extends BaseEntity> {

    private static final Logger logger = LogManager.getLogger(AbstractRestController.class);

    @GET
    @Path(value= "/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        logger.info("Find All " + T.ENTITY_TYPE);
        List<T> entitys = getService().getAll();
        if(entitys.isEmpty()){
            logger.info(T.ENTITY_TYPE + " empty");
            return Response.noContent().build();
        }
        logger.info(T.ENTITY_TYPE + " size = " + entitys.size());
        return Response.ok().entity(entitys).build();
    }

    @GET
    @Path(value= "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@FormParam("id") Integer id) {
        logger.info("Find " + T.ENTITY_TYPE + " with id" + id);
        T entity = (T) getService().findById(id);
        if (entity == null) {
            logger.error(T.ENTITY_TYPE + " with id " + id + " already exist");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        logger.info("Find " + T.ENTITY_TYPE + " with id" + id + " SUCCESSFULLY");
        return new ResponseEntity<T>(entity, Response.Status.OK);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> add(@RequestBody T entity, UriBuilder ucBuilder) {
        logger.info("Create " + T.ENTITY_TYPE);
        try {
            getService().add(entity);
        } catch (NonUniqueObject nonUniqueObject) {
            logger.error(T.ENTITY_TYPE + " with name " + entity.getName() + " already exist", nonUniqueObject);
            return new ResponseEntity<Void>(Response.Status.CONFLICT);
        }
        logger.info("Create " + T.ENTITY_TYPE + " with name " + entity.getName() + " SUCCESSFULLY");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(entity.getId()).toUri());
        return new ResponseEntity<Void>(headers, Response.Status.CREATED);
    }

    @PUT
    @Path(value= "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<T> update(@FormParam("id") Integer id, @RequestBody T entity) {
        logger.info("Updating " + T.ENTITY_TYPE + " id = " + id);
        try {
            getService().update(entity);
        } catch (NonExistObject nonExistObject) {
            logger.error(T.ENTITY_TYPE + " with id " + id + " not found");
            return new ResponseEntity<T>(Response.Status.NOT_FOUND);
        }
        logger.info("Updating " + T.ENTITY_TYPE + " with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<T>(entity, Response.Status.OK);
    }

    @DELETE
    @Path(value= "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<T> delete(@FormParam("id") Integer id) {
        logger.info("Deleting " + T.ENTITY_TYPE + " with id " + id);
        try {
            getService().deleteById(id);
        } catch (NonExistObject nonExistObject) {
            logger.error("Unable to delete. " + T.ENTITY_TYPE + " with id " + id + " not found");
            return new ResponseEntity<T>(Response.Status.NOT_FOUND);
        }
        logger.info("Deleting " + T.ENTITY_TYPE + " with id " + id + " SUCCESSFULLY");
        return new ResponseEntity<T>(Response.Status.NO_CONTENT);
    }

    abstract protected ServiceApi getService();
}
