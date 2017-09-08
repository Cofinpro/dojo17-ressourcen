package de.cofinpro.dojo.ressourcen.service;

import de.cofinpro.dojo.ressourcen.dao.DataObjectDao;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/ressourcen")
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
    public void createResourceRequest(@PathParam("title") String title) {
        ResourceRequest request = new ResourceRequest();
        request.setTitle(title);
        dataObjectDao.create(request);
    }
}
