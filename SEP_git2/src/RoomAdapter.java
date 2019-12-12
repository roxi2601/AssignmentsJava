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

  public RoomAdapter(){
    fileName = "rooms.bin";
    mfio = new MyFileIO();
  }

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
  public void addRoom(Room room)
  {
    RoomList rooms = getAllRooms();
      rooms.addRoom(room);
      saveRooms(rooms);
  }
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
