package Assignment1.model.radiator;

public class Radiator  {
private RadiatorState currentState;

public Radiator()
{
  currentState = new OffState();
}
public void turnUp() throws InterruptedException
{
    currentState.turnUp(this);
}
public void turnDown()
{
    currentState.turnDown(this);
}
public int getPower()
{
   return currentState.getPower();
}
public void setPowerState(RadiatorState state)
{
    this.currentState=state;
}
}
