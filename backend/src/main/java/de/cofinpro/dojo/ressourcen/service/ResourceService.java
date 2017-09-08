package de.cofinpro.dojo.ressourcen.service;

import de.cofinpro.dojo.ressourcen.dao.DataObjectDao;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/resources")
@Produces("application/json")
@Consumes("application/json")
public class ResourceService {
    
    @Inject
    private DataObjectDao dataObjectDao;
    
    @GET
    @Path("/requests")
    public List<ResourceRequest> getAllRequests() {
        return dataObjectDao.findAll(ResourceRequest.class);
    }
    
    @PUT
    @Path("/requests/create/{title}")
    public String createResourceRequest(@PathParam("title") String title) {
        ResourceRequest request = new ResourceRequest();
        request.setTitle(title);
        Key<ResourceRequest> createdKey = dataObjectDao.create(request);
        return String.valueOf(createdKey.getId());
    }

    @GET
    @Path("/requests/find/{id}")
    public ResourceRequest getRequest(@PathParam("id") String id) {
        ObjectId objectId = new ObjectId(id);
        return dataObjectDao.findById(ResourceRequest.class, objectId);
    }
}
