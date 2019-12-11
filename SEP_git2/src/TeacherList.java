import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Teacher objects.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class TeacherList implements Serializable
{
  private ArrayList<Teacher> teachers;

  /**
   * No-argument constructor initializing the TeacherList
   */
  public TeacherList()
  {
    teachers = new ArrayList<Teacher>();
  }

  /**
   * Gets all the teachers.
   * @return all the teachers
   */
  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers;
  }

  /**
   * Gets the size of the arrayList
   * @return the size of the arrayList
   */
  public int size() // new method because of an error in ChangeExaminerTab
  {
    return teachers.size();
  }
  /**
   * Gets a String representation of the TeacherList.
   *
   * @return a String containing information about all Teacher objects in the list - each Teacher object followed by a new line character
   */
  public String toString()
  {
    String returnStr = "";

    for (int i = 0; i < teachers.size(); i++)
    {
      Teacher temp = teachers.get(i);

      returnStr += temp + "\n";
    }
    return returnStr;
  }
}
