package Assignment1master.core;
import Assignment1master.mediator.TemperatureListModel;
import Assignment1master.view.control.ControlViewModel;
import Assignment1master.view.display.DisplayViewModel;

public class ViewModelFactory {

    private ControlViewModel  controlViewModel;
    private DisplayViewModel displayViewModel;
    public ViewModelFactory(ModelFactory mf) {

        controlViewModel = new ControlViewModel((TemperatureListModel) mf.getModel());
        displayViewModel = new DisplayViewModel((TemperatureListModel) mf.getModel());
    }
    public ControlViewModel getControlViewModel() {
        return controlViewModel;
    }

    public DisplayViewModel getDisplayViewModel() {
        return displayViewModel;
    }
}
