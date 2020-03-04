package Assignment1.model.radiator;

public class OffState implements RadiatorState{

    @Override
    public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power1State());
    }
    @Override
    public void turnDown(Radiator radiator) {
        System.out.println("It's not possible");
    }

    @Override
    public int getPower() {
        return 0;
    }
}
