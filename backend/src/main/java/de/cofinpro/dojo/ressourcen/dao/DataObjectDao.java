package de.cofinpro.dojo.ressourcen.dao;

import de.cofinpro.dojo.ressourcen.model.DataObject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.inject.Inject;
import java.util.List;

public class DataObjectDao {
    
    private final Datastore datastore;

    @Inject
    public DataObjectDao(Datastore datastore) {
        this.datastore = datastore;
    }

    public <T extends DataObject> List<T> findAll(Class<T> typeClass) {
        final Query<T> query = datastore.createQuery(typeClass);
        return query.asList();
    }

    public <T extends DataObject> void create(T obj) {
        datastore.save(obj);
    }

    public <T extends DataObject> void update(T obj) {
        datastore.save(obj);
    }

    public <T extends DataObject> void updateOrCreate(T obj) {
        if (obj.getId() == null) {
            create(obj);
            return;
        }
        if (reload(obj) != null) {
            update(obj);
        } else {
            create(obj);
        }
    }

    public <T extends DataObject> T reload(T obj) {
        return datastore.get(obj);
    }

    public <T extends DataObject> T findById(Class<T> typeClass, ObjectId id) {
        return datastore.find(typeClass).field("_id").equal(id).get();
    }

    public <T extends DataObject> List<T> findFullText(Class<T> typeClass, String text){
        return datastore.find(typeClass).search(text).order("_id").asList();
    }

    public <T extends DataObject> void delete(T obj) {
        datastore.delete(obj);
    }
}
