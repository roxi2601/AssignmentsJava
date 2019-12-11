public class Room
{
  private String number;
  private boolean HDMI;
  private boolean VGA;
  private boolean projector;
  private int seatsCapacity;
  public Room(String number, boolean HDMI, boolean VGA, boolean projector, int seatsCapacity)
  {
    this.number=number;
    this.HDMI=HDMI;
    this.VGA=VGA;
    this.projector=projector;
    this.seatsCapacity=seatsCapacity;
  }

  public String getNumber()
  {
    return number;
  }

  public boolean isHDMI()
  {
    return HDMI;
  }

  public boolean isVGA()
  {
    return VGA;
  }

  public boolean isProjector()
  {
    return projector;
  }

  public int getSeatsCapacity()
  {
    return seatsCapacity;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public void setHDMI(boolean HDMI)
  {
    this.HDMI = HDMI;
  }

  public void setVGA(boolean VGA)
  {
    this.VGA = VGA;
  }

  public void setProjector(boolean projector)
  {
    this.projector = projector;
  }

  public void setSeatsCapacity(int seatsCapacity)
  {
    this.seatsCapacity = seatsCapacity;
  }
  public String toString()
  {
    return "Number:"+number+" HDMI:"+isHDMI()+" VGA:"+isVGA()+" Projector:"+isProjector()+" Seats capacity:"+seatsCapacity;
  }
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
