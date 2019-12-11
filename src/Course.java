public class Course
{
  private Teacher teacher;
  private Room room;
  private int numberOfStudents;
  private String name;
  private String examType;
  public Course(String name, Teacher teacher, Room room, String examType, int numberOfStudents)
  {
    this.name=name;
    this.teacher=teacher;
    this.room=room;
    this.examType=examType;
    this.numberOfStudents=numberOfStudents;
  }

  public String getName()
  {
    return name;
  }

  public int getNumberOfStudents()
  {
    return numberOfStudents;
  }

  public Room getRoom()
  {
    return room;
  }

  public String getExamType()
  {
    return examType;
  }

  public Teacher getTeacher()
  {
    return teacher;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setNumberOfStudents(int numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  public void setRoom(Room room)
  {
    this.room = room;
  }

  public void setExamType(String examType)
  {
    this.examType = examType;
  }

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }
  public String toString()
  {
    return "Course name:"+name+" Teacher:"+teacher+" Room:"+room+" Exam type:"+examType+" Number of students:"+numberOfStudents;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Course))
    {
      return false;
    }
    Course other=(Course)obj;
    return name.equals(other.name) && teacher.equals(other.teacher) && room.equals(other.room) && examType.equals(other.examType)
        && numberOfStudents==other.numberOfStudents;
  }
}
