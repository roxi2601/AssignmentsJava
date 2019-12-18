import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a teacher with a name, availability and contact.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class Teacher implements Serializable
{
  private String name;
  private ArrayList<MyDate>unavailability;
  private String contact;

  /**
   * Two-argument constructor.
   * @param name the teacher's name
   * @param contact the teacher's contact
   */
  public Teacher(String name, String contact)
  {
    this.name=name;
    this.contact=contact;
    unavailability=new ArrayList<MyDate>();
  }

  /**
   * Gets the teacher's name.
   * @return the teacher's name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the teacher's availability.
   * @return the teacher's availability
   */
  public ArrayList<MyDate> getUnavailability()
  {
    return unavailability;
  }

  /**
   * Gets the teacher's contact.
   * @return the teacher's contact
   */
  public String getContact()
  {
    return contact;
  }

  /**
   * Sets the teacher's name.
   * @param name what the teacher's name will be set to
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the teacher's availability
   * @param unavailability if the teacher is unavailable in this time
   */
  public void setUnavailability(ArrayList<MyDate> unavailability)
  {
    this.unavailability = unavailability;
  }

  /**
   * Sets the teacher's contact.
   * @param contact the teacher's contact
   */
  public void setContact(String contact)
  {
    this.contact = contact;
  }

  /**
   * Returns a string representation of the teacher.
   * @return a string representation of the teacher in the format: "Name: name Availability: availability Contact: contact"
   */
  public String toString()
  {
    return name;
  }

  /**
   * Compares name and contact of two teachers.
   * @param obj the object to compare with
   * @return true if the given object is equal to this teacher
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Teacher))
    {
      return false;
    }
    Teacher other=(Teacher) obj;

    if(contact!= null && unavailability!=null)
    {
      return name.equals(other.name) && contact.equals(other.contact) && unavailability.equals(other.unavailability);
    }
    else
    {
      return false;
    }
  }
}
