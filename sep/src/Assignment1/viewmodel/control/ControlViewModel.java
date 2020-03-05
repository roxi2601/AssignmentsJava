package Assignment1.viewmodel.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Assignment1.mediator.TemperatureModel;


public class ControlViewModel {

    private StringProperty state;

    private TemperatureModel model;

    public ControlViewModel(TemperatureModel model) {
        this.model = model;
        state = new SimpleStringProperty();
        //How to make view model see changed state from 3 to 2(caused by running thread in Power3State constructor)
        model.addListener("Radiator state", evt->updateState());
    }
    public StringProperty stateProperty() {
        return state;
    }

    public void turnUpRadiator() throws InterruptedException
    {
      if(model.getRadiatorPower()!=3)
      model.turnUpRadiator();
    }
    public void turnDownRadiator()
    {
      if(model.getRadiatorPower()!=0)
      model.turnDownRadiator();
    }
    public void updateState()
    {
        int pwr = model.getRadiatorPower();
        state.setValue(pwr+"");
    }

    public int getRadiatorPower()
    {
        return model.getRadiatorPower();

    }
}
