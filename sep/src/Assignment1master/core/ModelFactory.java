package Assignment1master.core;

import Assignment1master.mediator.TemperatureListModel;

public class ModelFactory
{
    private TemperatureListModel model;

    public TemperatureListModel getModel() {
        if(model == null)
            model = new TemperatureListModel();
        return model;
    }
}

