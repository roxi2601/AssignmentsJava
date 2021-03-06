package Assignment1master.model.radiator;

public interface RadiatorState {
    public void turnUp(Radiator radiator) throws InterruptedException;
    public void turnDown(Radiator radiator);
    public int getPower();
}
