package Assignment1.model.radiator;

public class Power3State implements RadiatorState {

    private Thread thread;
    public Power3State(Radiator radiator)
    {
        thread = new Thread(() -> {
            try
            {
                Thread.sleep(5000);
                System.out.println("It's cooling down to 2nd state(thread finished");
                radiator.setPowerState(new Power2State());
            }
            catch (InterruptedException e)
            {
                System.out.println("thread in 3 state was interrupted ");
            }
        });
        thread.start();
    }
    @Override
    public void turnUp(Radiator radiator) {
        System.out.println("It's not possible");
    }
    @Override
    public void turnDown(Radiator radiator) {
        thread.interrupt();
        radiator.setPowerState(new Power2State());
    }
    @Override
    public int getPower() {
        return 3;
    }
}
