package Assignment1.model.radiator;

public class Power1State implements RadiatorState {
    private static final int POWER=1;
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
