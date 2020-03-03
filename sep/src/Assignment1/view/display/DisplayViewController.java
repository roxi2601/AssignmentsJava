package Assignment1.view.display;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Assignment1.viewmodel.display.DisplayViewModel;

public class DisplayViewController {
    @FXML
    Label HotOrCold;
    private DisplayViewModel displayViewModel;
    public void init(DisplayViewModel displayViewModel)
    {
        this.displayViewModel=displayViewModel;
        HotOrCold.textProperty().bind(displayViewModel.hotOrColdProperty());
    }
}
