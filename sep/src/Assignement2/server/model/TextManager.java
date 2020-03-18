package Assignement2.server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TextManager implements TextManagerModel
{
    private PropertyChangeSupport support;

    public TextManager()
    {
        support=new PropertyChangeSupport(this);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
