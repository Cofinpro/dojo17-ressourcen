package de.cofinpro.dojo.ressourcen.model;

import de.cofinpro.dojo.ressourcen.dao.DataObjectDao;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class ResourceRequest implements DataObject{
    
    @Id
    private ObjectId id;
    
    private String title;

    @Override
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
