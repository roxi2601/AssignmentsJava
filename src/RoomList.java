import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room>rooms;
  public RoomList()
  {
    rooms=new ArrayList<Room>();
  }
  public void addRoom(Room room)
  {
    rooms.add(room);
  }
  public void removeRoom(Room room)
  {
    rooms.remove(room);
  }
  public ArrayList<Room> getAllRooms()
  {
    return rooms;
  }
  public String toString()
  {
    String str="";
    for(int i=0;i<rooms.size();i++)
    {
      str+="Number:"+rooms.get(i).getNumber()+" HDMI:"+rooms.get(i).isHDMI()+" VGA:"+rooms.get(i).isVGA()+""
          + "Projector:"+rooms.get(i).isProjector()+" Seats capacity:"+rooms.get(i).getSeatsCapacity();
    }
    return str;
  }

}
