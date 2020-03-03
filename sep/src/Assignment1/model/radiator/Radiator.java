package Assignment1.model.radiator;

public class Radiator  {
private RadiatorState currentState;
public void turnUp(RadiatorState state) throws InterruptedException
{
    currentState=state;
}
public void turnDown()
{
    currentState.turnDown(this);
}
public void getPower()
{currentState.getPower();
}
public void setPowerState(RadiatorState state)
{
    this.currentState=state;
}
}
