package Assignment1.core;
import Assignment1.mediator.TemperatureModel;
import Assignment1.view.control.ControlViewModel;
import Assignment1.view.display.DisplayViewModel;

public class ViewModelFactory {
    private ControlViewModel  controlViewModel;
    private DisplayViewModel displayViewModel;
    public ViewModelFactory(ModelFactory mf) {

        controlViewModel = new ControlViewModel((TemperatureModel)mf.getModel());
        displayViewModel = new DisplayViewModel((TemperatureModel)mf.getModel());
    }
    public ControlViewModel getControlViewModel() {
        return controlViewModel;
    }

    public DisplayViewModel getDisplayViewModel() {
        return displayViewModel;
    }
}
