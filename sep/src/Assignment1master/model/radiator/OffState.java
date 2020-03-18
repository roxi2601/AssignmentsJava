package Assignment1master.model.radiator;

public class OffState implements RadiatorState{

    @Override
    public void turnUp(Radiator radiator) {
        System.out.println("its turning 0->1");
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
