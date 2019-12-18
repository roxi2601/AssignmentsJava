import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  A class to handle input and output streams for Rooms.
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class RoomAdapter//Can it be like that or should it be more like in TeacherAdapter????
{
  private MyFileIO mfio;
  private String fileName;
  /**
   * constructor Room adapter has methods for managing rooms data
   * @author Julia Tankiewicz
   */
  public RoomAdapter()
  {
    fileName = "sep/rooms.bin";
    mfio = new MyFileIO();
  }
  /**
   *method update course box
   * @author Julia Tankiewicz
   */
  public RoomList getAllRooms()
  {
    RoomList rooms = new RoomList();
    try
    {
      rooms = (RoomList) mfio.readObjectFromFile(fileName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return rooms;
  }
  /**
   *method saves rooms given as parameter to external file
   * @author Julia Tankiewicz
   */
  public void saveRooms(RoomList rooms)
  {
    try
    {
     mfio.writeToFile(fileName,rooms);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   *method adds new room to rooms binary file
   * @author Julia Tankiewicz
   */
  public void addRoom(Room room)
  {
    RoomList rooms = getAllRooms();
      rooms.addRoom(room);
      saveRooms(rooms);
  }
  /**
   *method removes existing room from file
   * @author Julia Tankiewicz
   */
  public void removeRoom(Room room)
  {
    RoomList rooms = getAllRooms();
    for(int i = 0;i<rooms.size();i++)
    {
      if(rooms.getRoom(i).equals(room))
      {
        rooms.removeRoom(i);
      }
    }
    saveRooms(rooms);
  }
  /**
   *method changes room from file matching with one given as parameter 'room' into 'changedRoom' object
   * @author Julia Tankiewicz
   */
  public void changeRoom(Room room, Room changedRoom)
  {
    RoomList rooms = getAllRooms();
    for(int i = 0;i<rooms.size();i++)
    {
      if(rooms.getRoom(i).equals(room))
      {
        rooms.removeRoom(i);
        rooms.addRoom(changedRoom);
      }
    }
    saveRooms(rooms);
  }


}
