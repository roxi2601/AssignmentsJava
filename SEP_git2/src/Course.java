import java.io.Serializable;

/**
 *  A class representing a course with teacher, room, number of students, name and exam type
 * @author Roksana Dziadowicz
 * @version 1.0
 */

public class Course implements Serializable
{
  private Teacher teacher;
  private Room room;
  private int numberOfStudents;
  private String name;
  private String examType;// if its oral room needs projector

  /**
   * Five-argument constructor.
   * @param name the course's name
   * @param teacher the course's teacher
   * @param room the course's room
   * @param examType the course's exam type
   * @param numberOfStudents number of students in the course
   */
  public Course(String name, Teacher teacher, Room room, String examType, int numberOfStudents)
  {
    this.name=name;
    this.teacher=teacher;
    this.room=room;
    this.examType=examType;
    this.numberOfStudents=numberOfStudents;
  }

  /**
   * Gets the course's name
   * @return the course's name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the number of students in the course
   * @return the number of students in the course
   */

  public int getNumberOfStudents()
  {
    return numberOfStudents;
  }

  /**
   * Gets the course' room
   * @return the course's room
   */

  public Room getRoom()
  {
    return room;
  }

  /**
   * Gets the course' s exam type
   * @return the course's exam type
   */

  public String getExamType()
  {
    return examType;
  }

  /**
   * Gets the course's teacher
   * @return the course's teacher
   */

  public Teacher getTeacher()
  {
    return teacher;
  }

  /**
   * Sets the course's name.
   * @param name what the course's name will be set to
   */

  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets number of students in the course.
   * @param numberOfStudents what number of students in the course will be set to
   */

  public void setNumberOfStudents(int numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  /**
   * Sets the course's room.
   * @param room what the course's room will be set to
   */

  public void setRoom(Room room)
  {
    this.room = room;
  }

  /**
   * Sets the course's exam type.
   * @param examType what the course's exam type will be set to
   */

  public void setExamType(String examType)
  {
    this.examType = examType;
  }

  /**
   * Sets the course's teacher.
   * @param teacher what the course's teacher will be set to
   */

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }

  /**
   * Returns a string representation of the course.
   * @return a string representation of the course in the format: "Course name: name Teacher: teacher Room: room Exam type: examType Number of students: numberOfStudents"
   */
  public String toString()
  {
    return name;
  }

  /**
   * Compares name, teacher, room, exam type and number of students of two courses
   * @param obj the object to compare with
   * @return true if the given object is equal to this course
   */
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
