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
        stateLabel.textProperty().set(0 + "");
    }
    @FXML
    public void onUpButton(ActionEvent actionEvent) throws InterruptedException
    {
        controlViewModel.turnUpRadiator();
        stateLabel.textProperty().set(controlViewModel.getRadiatorPower()+"");
    }
    @FXML
    public void onDownButton(ActionEvent actionEvent) {
        controlViewModel.turnDownRadiator();
        stateLabel.textProperty().set(controlViewModel.getRadiatorPower()+"");
    }


}
