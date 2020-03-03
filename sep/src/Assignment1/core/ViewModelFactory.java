package Assignment1.core;
import Assignment1.viewmodel.control.ControlViewModel;
import Assignment1.viewmodel.display.DisplayViewModel;

public class ViewModelFactory {
    private ControlViewModel  controlViewModel;
    private DisplayViewModel displayViewModel;
    public ViewModelFactory(ModelFactory mf) {
        controlViewModel = new ControlViewModel(mf.getModel());
        displayViewModel = new DisplayViewModel(mf.getModel());
    }
    public ControlViewModel getControlViewModel() {
        return controlViewModel;
    }

    public DisplayViewModel getDisplayViewModel() {
        return displayViewModel;
    }
}
