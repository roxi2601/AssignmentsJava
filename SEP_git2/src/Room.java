import java.io.Serializable;

 /**
 * A class representing a room with information about room number, HDMI, VGA, projector and seats capacity.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class Room implements Serializable
{
  private String number;
  private boolean projector;
  private int seatsCapacity;

  /**
   * Two-argument constructor.
   * @param seatsCapacity the room's seats capacity
   */
  public Room(String number,int seatsCapacity)
  {
    this.number=number;
    this.projector=false;
    this.seatsCapacity=seatsCapacity;
  }

  /**
   * Gets the room's number.
   * @return the room's number
   */
  public String getNumber()
  {
    return number;
  }

  /**
   * Gets the projector (if the projector is in the room)
   * @return the room's projector (if the projector is in the room)
   */
  public boolean isProjector()
  {
    return projector;
  }

  /**
   * Gets the room's seats capacity.
   * @return the room's seats capacity
   */
  public int getSeatsCapacity()
  {
    return seatsCapacity;
  }

  /**
   * Sets the room'number.
   * @param number what the room's number will be set to
   */
  public void setNumber(String number)
  {
    this.number = number;
  }
  /**
   * Sets the room's projector
   * @param projector what the room's projector will be set to (true of false)
   */
  public void setProjector(boolean projector)
  {
    this.projector = projector;
  }
  /**
   * Sets the room's seats capacity
   * @param seatsCapacity what the room's seatsCapacity will be set to
   */
  public void setSeatsCapacity(int seatsCapacity)
  {
    this.seatsCapacity = seatsCapacity;
  }

  /**
   * Returns a string representation of the room.
   * @return a string representation of the room in the format: "Number: number HDMI: isHDMI() VGA: isVGA() Projector: isProjector() Seats capacity: seatsCapacity"
   */
  public String toString()
  {
    return "Number:"+number+" Projector:"+isProjector()+" Seats capacity:"+seatsCapacity;
  }

  /**
   * Compares number and seats capacity of two rooms.
   * @param obj the object to compare with
   * @return true if the given object is equal to this room
   */
  public boolean equals(Object obj)
  {
    if(!((obj instanceof Room)))
    {
      return false;
    }
    Room other=(Room)obj;
    return number.equals(other.number) && seatsCapacity==other.seatsCapacity;
  }
}
