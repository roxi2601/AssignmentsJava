import java.io.FileNotFoundException;
import java.io.IOException;

public class TeacherAdapter
{
  private  MyFileIO mfio;
  private String fileName;
  /**
   *constructor of teacher adapter object
   * @author Julia Tankiewicz
   */
  public TeacherAdapter()
  {
    mfio = new MyFileIO();
    this.fileName = "sep/teachers.bin";
  }
  /**
   *method saves teacher list given as parameter to external file
   * @author Julia Tankiewicz
   */
  public void saveTeachers(TeacherList teachers)
  {
    try
    {
      mfio.writeToFile(fileName,teachers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   *method returns all teachers from file
   * @author Julia Tankiewicz
   */
  public TeacherList getAllTeachers()
  {
    TeacherList teachers = new TeacherList();
    try
    {
      teachers = (TeacherList)mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return teachers;
  }
  /**
   *method adds new teacher to file
   * @author Julia Tankiewicz
   */
  public void addTeacher(Teacher teacher)
  {
    TeacherList teachers = getAllTeachers();
    teachers.addTeacher(teacher);
    saveTeachers(teachers);
  }
  /**
   *method changes teacher from file matching with one given as parameter 'teacher' into 'changedTeacher' object
   * @author Julia Tankiewicz
   */
  public void changeTeacher(Teacher teacher,Teacher changedTeacher)
  {
    TeacherList teachers = getAllTeachers();
    teachers.removeTeacher(teacher);
    teachers.addTeacher(changedTeacher);
    saveTeachers(teachers);
  }
  /**
   *method removes teacher object from file
   */
  public void removeTeacher(Teacher teacher)
  {
    TeacherList teachers = getAllTeachers();
    teachers.removeTeacher(teacher);
    saveTeachers(teachers);
  }
}
