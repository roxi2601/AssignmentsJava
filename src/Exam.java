import java.util.ArrayList;

public abstract class Exam
{
  private Teacher examiner;
  private MyDate date;
  private Room room;
  private Course course;
  private int numberOfStudents;
  public Exam(Course course, Teacher examiner, Room room, MyDate date)
  {
    this.room=room;
    this.examiner=examiner;
    this.date=date;
    this.course=course;
  }

  public Course getCourse()
  {
    return course;
  }

  public Room getRoom()
  {
    return room;
  }
  public int getNumberOfStudents()
  {
    return numberOfStudents;
  }
  public Teacher getExaminer()
  {
    return examiner;
  }
  public MyDate getDate()
  {
    return date;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setNumberOfStudents(int numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  public void setRoom(Room room)
  {
    this.room = room;
  }

  public void setExaminer(Teacher examiner)
  {
    this.examiner = examiner;
  }

  public void setDate(MyDate date)
  {
    this.date = date;
  }
  public void reserveRoom() //????????????
  {
    this.room=room;
  }
  public abstract String getType();
  public String toString()
  {
    return "Course:"+course+" Examiner:"+examiner+" Date:"+date+" Room:"+room+" Number of students:"+numberOfStudents;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Exam))
    {
      return false;
    }
    Exam other=(Exam)obj;
    return course.equals(other.course) && numberOfStudents==other.numberOfStudents && room.equals(other.room) && examiner.equals(other.examiner) && date.equals(other.date);
  }
}
