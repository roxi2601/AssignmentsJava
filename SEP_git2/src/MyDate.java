import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a date with a day, month and year.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class MyDate implements Serializable
{
  private int day;
  private int month;
  private int year;
  private ArrayList<TimePeriod> hours;// delate it and make it as one class with two hours parameters

  /**
   * Three-argument constructor.
   * @param day the day of the exam
   * @param month the month of the exam
   * @param year the year of the exam
   */
  public MyDate(int day, int month, int year)
  {
    hours = new ArrayList<TimePeriod>();
    this.day=day;
    this.month=month;
    this.year=year;
  }

  /**
   * Sets hours of exam.
   * @param hour the hour of the exam
   */
  public void setHours(TimePeriod hour)
  {
    hours.add(hour);
  }

  /**
   * Sets the day of the exam.
   * @param day what the exam's day will be set to
   */
  public void setDay(int day)
  {
    this.day = day;
  }
  /**
   * Sets the month of the exam.
   * @param month what the exam's month will be set to
   */
  public void setMonth(int month)
  {
    this.month = month;
  }
  /**
   * Sets the year of the exam.
   * @param year what the exam's year will be set to
   */
  public void setYear(int year)
  {
    this.year = year;
  }

  /**
   * Gets the day of the exam.
   * @return the day of the exam
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Gets the month of the exam.
   * @return the month of the exam
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Gets the year of the exam.
   * @return the year of the exam
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Gets hours of the exam.
   * @return hours of the exam
   */
  public ArrayList<TimePeriod> getHours()
  {
    return hours;
  }

  /**
   * Copies information from MyDate class.
   * @return copied information from MyDate class
   */
  public MyDate copy()
  {
    return new MyDate(day,month,year);
  }

  /**
   * Returns a string representation of the date.
   * @return a string representation of the date in the format: "day/month/year hours"
   */
  public String toString()
  {
    String str="";
    for(int i = 0;i<hours.size();i++)
    {
      str+=hours.get(i)+" ";
    }
    return day+"/"+month+"/"+year+" "+str;
  }

  /**
   * Compares day, month and year of two exams.
   * @param obj the object to compare with
   * @return true if the given object is equal to this exam
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other=(MyDate)obj;
    return day==other.day && month==other.month && year==other.year;
  }
}
