public class MyDate
{
  private int day;
  private int month;
  private int year;
  public MyDate(int day, int month, int year)
  {
    this.day=day;
    this.month=month;
    this.year=year;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }
  public MyDate copy()
  {
    return new MyDate(day,month,year);
  }
  public String toString()
  {
    return "Date:"+day+"/"+month+"/"+year;
  }
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
