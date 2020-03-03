package Assignment1.core;

import Assignment1.mediator.Model;
import Assignment1.mediator.TemperatureModel;


public class ModelFactory
{
    private TemperatureModel model;

    public Model getModel() {
        if(model == null)
            model = new TemperatureModel();
        return model;
    }
}

