package de.cofinpro.dojo.ressourcen.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class ResourceRequest implements DataObject{
    
    @Id
    private ObjectId id;
    
    private String title;

    @Override
    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceRequest that = (ResourceRequest) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
