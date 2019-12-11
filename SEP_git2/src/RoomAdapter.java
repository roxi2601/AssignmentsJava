import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  A class to handle input and output streams for Rooms.
 * @author Prabhjot Singh
 * @version 1.0
 */
public class RoomAdapter
{
  private MyFileIO fileIO;
  private String fileName;

  public RoomAdapter(){
    fileName = "roomdata.bin";
    fileIO = new MyFileIO();
  }
We need also methods: remove room and update room's data!!!! remember to check if it can be changed to prevent exeptions!!!
  public void addObject(Room obj){
    try
    {
      fileIO.writeToFile(fileName, obj);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error writing to file");
    }
  }

  public RoomList getAllRooms(){
    RoomList rooms = new RoomList();
    try
    {
      rooms = (RoomList) fileIO.readObjectFromFile(fileName);
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
}
