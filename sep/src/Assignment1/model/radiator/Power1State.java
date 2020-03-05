package Assignment1.model.radiator;

public class Power1State implements RadiatorState {

    @Override
    public void turnUp(Radiator radiator) {
        System.out.println("its turning 1->2 state");
        RadiatorState radiatorState=new Power2State();
        radiator.setPowerState(radiatorState);
    }

    @Override
    public void turnDown(Radiator radiator) {
        System.out.println("its turning 1->0");
        RadiatorState radiatorState=new OffState();
        radiator.setPowerState(radiatorState);
    }

    @Override
    public int getPower() {
        return 1;
    }
}
