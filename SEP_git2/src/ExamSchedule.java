import java.io.Serializable;
import java.util.ArrayList;

/**
 *  A class containing a list of Exam objects.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ExamSchedule implements Serializable
{
  private ArrayList<Exam> exams;

  /**
   * No-argument constructor.
   */
  public ExamSchedule()
  {
    exams = new ArrayList<Exam>();
  }

  /**
   * Gets all exams
   * @return all exams
   */
  public ArrayList<Exam> getAllExams()
  {
    return exams;
  }

  /**
   * Gets an Exam object from position index from the list.
   * @param index the position in the list of the Exam object
   * @return the Exam object at position index
   */
  public Exam getExam(int index)
  {
    return exams.get(index);
  }

  /**
   * Gets how many Exam objects are in the list.
   * @return the number of Exam object in the list
   */
  public int size()
  {
    return exams.size();
  }

  /**
   * Gets all Exam objects with the given courses names.
   * @param courseName the course name of the Exam object
   * @return all the Exam objects with the given courses names
   */
  public ArrayList<Exam> getAllExams(String courseName)
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getCourse().getName().equals(courseName)))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }

  /**
   * Gets all the Exam object with the given oral type of the exam.
   * @return all the Exam objects with the given oral type of the exam
   */
  public ArrayList<Exam> getAllOralExams()
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getType().equals("Oral")))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }
  /**
   * Gets all the Exam object with the given written type of the exam.
   * @return all the Exam objects with the given written type of the exam
   */
  public ArrayList<Exam> getAllWrittenExams()
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getType().equals("Written")))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }

  /**
   * Edit exam.
   * @param exam exam to edit
   */
  public void editExam(Exam exam)
  {
    //should it be in GUI adapter???
  }

  /**
   * Adds an Exam to the exam schedule.
   * @param exam the exam to add to the exam schedule
   */
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }
  /**
   * Removes an Exam from the exam schedule.
   * @param exam the exam to remove from the exam schedule
   */
  public void removeExam(Exam exam)
  {
    exams.remove(exam);
  }
  /**
   * Gets an Exam object from position index from the list.
   * @param index the position in the list of the Exam object
   * @return the Exam object at position index if one exists, else null
   */
  public Exam get(int index)
  {
    if(index<exams.size())
    {
      return exams.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Gets a String representation of the ExamSchedule.
   * @return a String containing information about all Exam objects in the list - each Exam object followed by a new line character
   */
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<exams.size(); i++)
    {
      Exam temp = exams.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
}
