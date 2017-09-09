package de.cofinpro.dojo.ressourcen.ui;

import de.cofinpro.dojo.ressourcen.model.ResourceRequest;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class GlobalViewModel implements Serializable {

    private ResourceRequest currentlySelectedResourceRequest;

    public static final String SINGLE_RR_CHOSEN = "einzelner RR ausgewaehlt";

    private final PropertyChangeSupport notifier = new PropertyChangeSupport(
            this);

    public void addPropertyChangeListener(PropertyChangeListener arg0) {
        notifier.addPropertyChangeListener(arg0);
    }

    public void addPropertyChangeListener(String arg0,
                                          PropertyChangeListener arg1) {
        notifier.addPropertyChangeListener(arg0, arg1);
    }

    public void removePropertyChangeListener(PropertyChangeListener arg0) {
        notifier.removePropertyChangeListener(arg0);
    }

    public void removePropertyChangeListener(String arg0,
                                             PropertyChangeListener arg1) {
        notifier.removePropertyChangeListener(arg0, arg1);
    }

    public ResourceRequest getCurrentlySelectedResourceRequest() {
        return currentlySelectedResourceRequest;
    }

    public void setCurrentlySelectedResourceRequest(ResourceRequest currentlySelectedResourceRequest) {
        Object oldValue = this.currentlySelectedResourceRequest;
        this.currentlySelectedResourceRequest = currentlySelectedResourceRequest;
        notifier.firePropertyChange(SINGLE_RR_CHOSEN,oldValue,this.currentlySelectedResourceRequest);
    }

}
