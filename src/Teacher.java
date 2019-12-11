import java.util.ArrayList;

public class Teacher
{
  private String name;
  private ArrayList<MyDate>availability;
  private String contact;
  public Teacher(String name, String contact)
  {
    this.name=name;
    this.contact=contact;
    availability=new ArrayList<MyDate>();
  }

  public String getName()
  {
    return name;
  }
  public ArrayList<MyDate> getAvailability()
  {
    return availability;
  }

  public String getContact()
  {
    return contact;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setAvailability(ArrayList<MyDate> availability)
  {
    this.availability = availability;
  }

  public void setContact(String contact)
  {
    this.contact = contact;
  }
  public String toString()
  {
    return "Name:"+name+"\nAvailability:"+availability+"\nContact:"+contact;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Teacher))
    {
      return false;
    }
    Teacher other=(Teacher) obj;
    return name.equals(other.name) && contact.equals(other.contact) && availability.equals(other.availability);
  }
}
