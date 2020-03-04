package Assignment1.model.radiator;

public class Power1State implements RadiatorState {

    @Override
    public void turnUp(Radiator radiator) {
        RadiatorState radiatorState=new Power2State();
        radiator.setPowerState(radiatorState);
    }

    @Override
    public void turnDown(Radiator radiator) {
        RadiatorState radiatorState=new OffState();
        radiator.setPowerState(radiatorState);
    }

    @Override
    public int getPower() {
        return 1;
    }
}
