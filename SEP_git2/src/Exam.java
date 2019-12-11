import java.io.Serializable;

/**
 *  An abstract class representing a exam with examiner, date, room, course, kind.
 * @author Roksana Dziadowicz
 * @version 1.0
 */

public abstract class Exam implements Serializable
{
  private Teacher examiner;
  private Teacher coexaminer;
  private MyDate date;
  private Room room;
  private Course course;

  /**
   * Four-argument constructor.
   * @param course the exam's course
   * @param examiner the exam's examiner
   * @param date the exam's date
   * @param room the exam' room
   */
  public Exam(Course course, Teacher examiner, MyDate date, Room room)
  {
    this.room=room;
    this.examiner=examiner;
    this.coexaminer=null;
    this.date=date;
    this.course=course;
  }
  /**
   * Five-argument constructor.
   * @param course the exam's course
   * @param examiner the exam's examiner
   * @param coexaminer the exam's coexaminer
   * @param date the exam's date
   * @param room the exam' room
   */
  public Exam(Course course, Teacher examiner,Teacher coexaminer, MyDate date, Room room)
  {
    this.room=room;
    this.examiner=examiner;
    this.coexaminer=coexaminer;
    this.date=date;
    this.course=course;
  }

  /**
   * Gets the exam's course.
   * @return the exam's course
   */
  public Course getCourse()
  {
    return course;
  }
  /**
   * Gets the exam's room
   * @return the exam's room
   */
  public Room getRoom()
  {
    return room;
  }

  /**
   * Gets the number of students on the exam.
   * @return the number of students on the exam
   */
  public int getNumberOfStudents()
  {
    return course.getNumberOfStudents();
  }

  /**
   * Gets exam's examiner.
   * @return the exam's examiner
   */
  public Teacher getExaminer()
  {
    return examiner;
  }

  /**
   * Gets the date of the exam.
   * @return the date of the exam
   */
  public MyDate getDate()
  {
    return date;
  }

  /**
   * Sets the exam's course.
   * @param course what the exam's course will be set to
   */
  public void setCourse(Course course)
  {
    this.course = course;
  }

  /**
   * Sets number of students on the exam.
   * @param numberOfStudents what number of students will be set to
   */
  public void setNumberOfStudents(int numberOfStudents)
  {
    course.setNumberOfStudents(numberOfStudents);
  }

  /**
   * Sets exam's examiner.
   * @param examiner what the exam's examiner will be set to
   */
  public void setExaminer(Teacher examiner)
  {
    this.examiner = examiner;
  }

  /**
   * Sets the date of the exam
   * @param date what the date of the exam will be set to
   */
  public void setDate(MyDate date)
  {
    this.date = date;
  }

  /**
   * Reserves room for the exam.
   * @param room room's number for the reservation
   */
  public void reserveRoom(Room room)
  {
    this.room=room;
  }

  /**
   * Gets the exam's type.
   * @return "Written" or "Oral"
   */
  public abstract String getType();

  /**
   * Returns a string representation of the exam.
   * @return a string representation of the exam in the format: " course examiner type date room"
   */
  public String toString()
  {
    return course+" "+examiner+" "+getType()+" "+date+" "+room; //???????????//
  }

  /**
   * Compares course, examiner, date and room of two exams.
   * @param obj the object to compare with
   * @return true if the given object is equal to this exam
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Exam))
    {
      return false;
    }
    Exam other=(Exam)obj;
    return course.equals(other.course) && room.equals(other.room) && examiner.equals(other.examiner) && date.equals(other.date);
  }
}
