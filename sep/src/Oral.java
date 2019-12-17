import java.io.Serializable;

/**
 * A class containing Oral objects and methods
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class Oral extends Exam implements Serializable
{
  /**
   * Four-argument constructor.
   * @param course the exam's course
   * @param examiner the exam's examiner
   * @param date the exam's date
   * @param room the exam's room
   */
  public Oral(Course course ,Teacher examiner,Teacher coexaminer, MyDate date, Room room)
  {
    super(course, examiner, date, room);
  }
  /**
   * Five-argument constructor.
   * @param course the exam's course
   * @param examiner the exam's examiner
   * @param date the exam's date
   * @param room the exam's room
   */
  public Oral(Course course ,Teacher examiner, MyDate date, Room room)
  {
    super(course, examiner, date, room);
  }
  /**
   * Gets type of the exam.
   * @return "Oral"
   */
  public String getType()
  {
    return "Oral";
  }

  /**
   * Returns a string representation of the oral (exam).
   * @return a string representation of the oral (exam) in the format: " course examiner date room Oral"
   */
  public String toString()
  {
    return super.toString()+" Oral";
  }
}
