package Assignment1master.model.radiator;

public class Power2State implements RadiatorState {

    @Override
    public void turnUp(Radiator radiator) throws InterruptedException {
        System.out.println("It's getting max hot");
        radiator.setPowerState(new Power3State(radiator));
    }

    @Override
    public void turnDown(Radiator radiator) {
        radiator.setPowerState(new Power1State());
        System.out.println("It's cooling down to1st state");
    }

    @Override
    public int getPower() {
        return 2;
    }
}
