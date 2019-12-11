import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a time period with a start hour, start minute, end hour and end minute.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class TimePeriod implements Serializable
{
  private int startHour;
  private int startMinute;
  private int endHour;
  private int endMinute;

  /**
   * Four-argument constructor.
   * @param startHour the exam's start hour
   * @param startMinute the exam's start minute
   * @param endHour the exam's end hour
   * @param endMinute the exam's end minute
   */
  public TimePeriod(int startHour, int startMinute, int endHour, int endMinute)
  {
    this.startHour=startHour;
    this.startMinute=startMinute;
    this.endHour=endHour;
    this.endMinute=endMinute;
  }

  /**
   * Gets the exam's start hour.
   * @return the exam's start hour
   */
  public int getStartHour()
  {
    return startHour;
  }
  /**
   * Gets the exam's start minute.
   * @return the exam's start minute
   */
  public int getStartMinute()
  {
    return startMinute;
  }
  /**
   * Gets the exam's end hour.
   * @return the exam's end hour
   */
  public int getEndHour()
  {
    return endHour;
  }
  /**
   * Gets the exam's end minute.
   * @return the exam's end minute
   */
  public int getEndMinute()
  {
    return endMinute;
  }

  /**
   * Sets the exam's start hour.
   * @param startHour what the exam's start hour will be set to
   */
  public void setStartHour(int startHour)
  {
    this.startHour = startHour;
  }

  /**
   * Sets the exam's start minute.
   * @param startMinute what the exam's start minute will be set to
   */
  public void setStartMinute(int startMinute) { this.startMinute = startMinute; }
  /**
   * Sets the exam's end hour.
   * @param endHour what the exam's end hour will be set to
   */
  public void setEndHour(int endHour)
  {
    this.endHour = endHour;
  }
  /**
   * Sets the exam's end minute.
   * @param endMinute what the exam's end minute will be set to
   */
  public void setEndMinute(int endMinute)
  {
    this.endMinute = endMinute;
  }

  /**
   * Copies information from TimePeriod class.
   * @return copied information from TimePeriod class
   */
  public TimePeriod copy()
  {
    return new TimePeriod(startHour,startMinute,endHour,endMinute);
  }

  /**
   * Returns a string representation of the time period.
   * @return a string representation of the time period in the format:"startHour:startMinute-endHour:endMinute"
   */
  public String toString()
  {
    return startHour+":"+startMinute+"-"+endHour+":"+endMinute;
  }

  /**
   * Compares start hour, start minute, end hour and end minute of two exams.
   * @param obj the object to compare with
   * @return true if the object is equal to this time period.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof TimePeriod))
    {
      return false;
    }
    TimePeriod other=(TimePeriod)obj;
    return startHour==other.startHour && startMinute==other.startMinute && endHour==other.endHour && endMinute==other.endMinute;
  }

}
