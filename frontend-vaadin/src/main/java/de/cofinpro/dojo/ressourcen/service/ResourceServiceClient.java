package de.cofinpro.dojo.ressourcen.service;

import de.cofinpro.dojo.ressourcen.model.ResourceRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ResourceServiceClient {

    private Client client;

    private WebTarget baseTarget;

    private static final String DEFAULT_URL_BASE = "http://localhost:8080/resources-service/resources";

    public ResourceServiceClient(final String baseUrl) {
        client = ClientBuilder.newBuilder().build();
        baseTarget = client.target(baseUrl);
    }

    public ResourceServiceClient() {
        this(DEFAULT_URL_BASE);
    }

    public List<ResourceRequest> getAllResourceRequests() {
        GenericType<List<ResourceRequest>> genericType = new GenericType<List<ResourceRequest>>() {
        };
        Response response = baseTarget.path("requests").request().get();
        List<ResourceRequest> value = response.readEntity(genericType);
        response.close();  // You should close connections!
        return value;
    }

    public ResourceRequest getResourceRequestById(String id) {
        Response response = baseTarget.path("requests").path(id).request().get();
        return response.readEntity(ResourceRequest.class);
    }

    public ResourceRequest createNewRequest(ResourceRequest resourceRequest) {
        //"/requests/create"
        Entity<ResourceRequest> entity = Entity.entity(resourceRequest, MediaType.APPLICATION_JSON);
        Response response = baseTarget.path("requests").path("create").request().post(entity);
        String key = response.readEntity(String.class);
        response.close();  // You should close connections!
        return getResourceRequestById(key);
    }

    public ResourceRequest updateExistingRequest(ResourceRequest resourceRequest) {
        Entity<ResourceRequest> entity = Entity.entity(resourceRequest, MediaType.APPLICATION_JSON);
        String id = resourceRequest.getId();
        Response response = baseTarget.path("requests").path(id).request().put(entity);
        String updatedKey = response.readEntity(String.class);
        response.close();  // You should close connections!
        return getResourceRequestById(updatedKey);
    }
}