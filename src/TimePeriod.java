import java.util.ArrayList;

public class TimePeriod
{
  private int startHour;
  private int startMinute;
  private int endHour;
  private int endMinute;
  private ArrayList<MyDate>myDates;
  public TimePeriod(int startHour, int startMinute, int endHour, int endMinute)
  {
    this.startHour=startHour;
    this.startMinute=startMinute;
    this.endHour=endHour;
    this.endMinute=endMinute;
    myDates=new ArrayList<MyDate>();
  }
  public int getStartHour()
  {
    return startHour;
  }
  public int getStartMinute()
  {
    return startMinute;
  }
  public int getEndHour()
  {
    return endHour;
  }
  public int getEndMinute()
  {
    return endMinute;
  }
  public void setStartHour(int startHour)
  {
    this.startHour = startHour;
  }
  public void setStartMinute(int startMinute) { this.startMinute = startMinute; }
  public void setEndHour(int endHour)
  {
    this.endHour = endHour;
  }
  public void setEndMinute(int endMinute)
  {
    this.endMinute = endMinute;
  }
  //??????????????????????????????????????????????????????/
  public MyDate getDate(int day, int month, int year)
  {
    for(int i=0;i<myDates.size();i++)
    {
      if(!(myDates.get(i).getDay()==day && myDates.get(i).getMonth()==month && myDates.get(i).getYear()==year))
      {
        myDates.get(i);
      }
    }
    return null;
  }
  public void addDate(int day, int month, int year)
  {
    MyDate myDate=new MyDate(day,month,year);
    myDates.add(myDate);
  }
  public void removeDate(int day, int month, int year)
  {
    MyDate myDate=new MyDate(day,month,year);
    myDates.remove(myDate);
  }
  //??????????????????????????????????????????????????????????????????????????????????/
  public TimePeriod copy()
  {
    return new TimePeriod(startHour,startMinute,endHour,endMinute);
  }
  public String toString()
  {
   String str="";
   for(int i=0;i<myDates.size();i++)
   {
     str+="Date:"+myDates.get(i).getDay()+"/"+myDates.get(i).getMonth()+"/"+myDates.get(i).getYear()+""
         + "\nTime period: Start:"+startHour+","+startMinute+" End:"+endHour+","+endMinute;
   }
   return str;
  }
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
