package Assignment1.view.display;
import Assignment1.core.ViewHandler;
import Assignment1.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Assignment1.viewmodel.display.DisplayViewModel;

public class DisplayViewController {
    @FXML
    Label HotOrCold;

    private DisplayViewModel displayViewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler=viewHandler;
        displayViewModel = viewModelFactory.getDisplayViewModel();
        HotOrCold.textProperty().bind(displayViewModel.hotOrColdProperty());
    }

    @FXML
    public void onBackButton(ActionEvent actionEvent) throws Exception {
        viewHandler.openControlView();
    }
}
