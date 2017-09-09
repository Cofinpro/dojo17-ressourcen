package de.cofinpro.dojo.ressourcen.service;

import de.cofinpro.dojo.ressourcen.dao.DataObjectDao;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/resources")
@Produces("application/json")
@Consumes("application/json")
public class ResourceService {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceService.class.getName());

    @Inject
    private DataObjectDao dataObjectDao;

    @GET
    @Path("/requests")
    public List<ResourceRequest> getAllRequests() {
        return dataObjectDao.findAll(ResourceRequest.class);
    }

    @GET
    @Path("/requests/{id}")
    public ResourceRequest getRequestById(@PathParam("id") String id) {
        return dataObjectDao.findById(ResourceRequest.class, new ObjectId(id));
    }

    @POST
    @Path("/requests/create")
    public String createResourceRequest(ResourceRequest resourceRequest) {
        Key<ResourceRequest> createdKey = dataObjectDao.create(resourceRequest);
        LOG.info("Created RR: " + resourceRequest);
        return String.valueOf(createdKey.getId());
    }

    @PUT
    @Path("/requests/{id}")
    public String updateResourceRequest(@PathParam("id") String id, ResourceRequest resourceRequest) {
        ResourceRequest existingRR = dataObjectDao.findById(ResourceRequest.class, new ObjectId(id));
        if (existingRR == null) {
            throw new IllegalStateException("Cannot update nonexisting RR");
        }
        else {
            Key<ResourceRequest> updatedKey = dataObjectDao.update(resourceRequest);
            return String.valueOf(updatedKey.getId());
        }
    }

    @GET
    @Path("/requests/find/{id}")
    public ResourceRequest getRequest(@PathParam("id") String id) {
        ObjectId objectId = new ObjectId(id);
        return dataObjectDao.findById(ResourceRequest.class, objectId);
    }
    
    @DELETE
    @Path("/requests/{id}")
    public void deleteById(@PathParam("id") String id) {
        ResourceRequest request = this.getRequest(id);
        if (request != null) {
            dataObjectDao.delete(request);
        } else {
            throw new IllegalArgumentException("Unable to delete " + id);
        }
    }
}
