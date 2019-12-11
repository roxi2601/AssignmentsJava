import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Room objects.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class RoomList implements Serializable
{
  private ArrayList<Room>rooms;

  /**
   * No-argument constructor initializing the RoomList.
   */
  public RoomList()
  {
    rooms=new ArrayList<Room>();
  }

  /**
   * Adds a Room to the list.
   * @param room the room to add to the list
   */
  public void addRoom(Room room)
  {
    rooms.add(room);
  }
  /**
   * Removes a Room from the list.
   * @param room the room to remove from the list
   */
  public void removeRoom(Room room)
  {
    rooms.remove(room);
  }

  /**
   * Gets all the rooms
   * @return all the rooms
   */
  public ArrayList<Room> getAllRooms()
  {
    return rooms;
  }

  /**
   * Gets the size of the arrayList
   * @return the size of the arrayList
   */
  public int size() // new method because of an error in ChangeRoomTab
  {
    return rooms.size();
  }
  /**
 * Gets a String representation of the RoomList.
 * @return a String containing information about all Room objects in the list - each Room object followed by a new line character
 */
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<rooms.size(); i++)
    {
      Room temp = rooms.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }

}
