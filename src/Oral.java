public class Oral extends Exam
{
  public Oral(Room room, Teacher examiner, MyDate date, Course course)
  {
    super(course, examiner, room, date);
  }
  public void planBreak() //????????/
  {

  }
  public void reserveRoom() //??????????
  {

  }
  public String getType()
  {
    return "Oral";
  }

  public String toString()
  {
    return super.toString();
  }
}
