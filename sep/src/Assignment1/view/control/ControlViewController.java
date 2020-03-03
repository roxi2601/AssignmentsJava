package Assignment1.view.control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Assignment1.viewmodel.control.ControlViewModel;

public class ControlViewController {

    @FXML
    Label stateLabel;
    private ControlViewModel controlViewModel;
    public void init(ControlViewModel controlViewModel)
    {
        this.controlViewModel=controlViewModel;
        stateLabel.textProperty().bindBidirectional(controlViewModel.stateProperty());
    }
    @FXML
    public void onUpButton(ActionEvent actionEvent) {
        controlViewModel.turnUpButton();
    }
    @FXML
    public void onDownButton(ActionEvent actionEvent) {
        controlViewModel.turnDownButton();
    }


}
