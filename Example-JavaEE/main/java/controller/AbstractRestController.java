package controller;

import model.BaseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
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
    public Response getById(@PathParam("id") Integer id) {
        logger.info("Find " + T.ENTITY_TYPE + " with id" + id);
        T entity = (T) getService().findById(id);
        if (entity == null) {
            logger.error(T.ENTITY_TYPE + " with id " + id + " already exist");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        logger.info("Find " + T.ENTITY_TYPE + " with id" + id + " SUCCESSFULLY");
        return Response.ok().entity(entity).build();
    }

    @POST
    //@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(T entity, @Context UriInfo uriInfo) {
        logger.info("Create " + T.ENTITY_TYPE);
        Integer newEntityId;
        try {
            newEntityId = getService().add(entity);
        } catch (NonUniqueObject nonUniqueObject) {
            logger.error(T.ENTITY_TYPE + " with name " + entity.getName() + " already exist", nonUniqueObject);
            return Response.status(Response.Status.CONFLICT).build();
        }
        logger.info("Create " + T.ENTITY_TYPE + " with name " + newEntityId + " SUCCESSFULLY");
        String rawPath = uriInfo.getAbsolutePath().getRawPath() + newEntityId;
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().replacePath(rawPath);
        return Response.created(uriBuilder.build()).status(Response.Status.CREATED).build();

    }

    @PUT
    @Path(value= "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, T entity) {
        logger.info("Updating " + T.ENTITY_TYPE + " id = " + id);
        try {
            getService().update(entity);
        } catch (NonExistObject nonExistObject) {
            logger.error(T.ENTITY_TYPE + " with id " + id + " not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        logger.info("Updating " + T.ENTITY_TYPE + " with id " + id + " SUCCESSFULLY");
        return Response.ok().entity(entity).build();
    }

    @DELETE
    @Path(value= "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        logger.info("Deleting " + T.ENTITY_TYPE + " with id " + id);
        try {
            getService().deleteById(id);
        } catch (NonExistObject nonExistObject) {
            logger.error("Unable to delete. " + T.ENTITY_TYPE + " with id " + id + " not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        logger.info("Deleting " + T.ENTITY_TYPE + " with id " + id + " SUCCESSFULLY");
        return Response.status(Response.Status.GONE).build();
    }

    abstract protected ServiceApi getService();
}
