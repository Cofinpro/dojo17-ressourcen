package de.cofinpro.dojo.ressourcen.dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class DatabaseProducer {
    
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseProducer.class);
    
    @Produces
    public Morphia produceMorphia() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("de.cofinpro.dojo.ressourcen.model");
        return morphia;
    }

    @Produces
    public MongoClient produceMongoClient() {
        return new MongoClient("127.0.0.1");
    }
    
    @ApplicationScoped
    @Produces
    public Datastore produceDatastore(MongoClient mongoClient, Morphia morphia) {
        Datastore datastore = morphia.createDatastore(mongoClient, "RESMAN");
        datastore.ensureCaps();
        morphia.map();
        try {
            datastore.ensureIndexes();
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return datastore;
    }
    
    public void disposeMongoClient(@Disposes MongoClient client) {
        client.close();
    }
}
