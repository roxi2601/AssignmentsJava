import java.io.FileNotFoundException;
import java.io.IOException;

public class TeacherAdapter
{
  private  MyFileIO mfio;
  private String fileName;

  public TeacherAdapter()
  {
    mfio = new MyFileIO();
    this.fileName = "sep/teachers.bin";
  }
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
  public void addTeacher(Teacher teacher)
  {
    TeacherList teachers = getAllTeachers();
    teachers.addTeacher(teacher);
    saveTeachers(teachers);
  }
  public void changeTeacher(Teacher teacher,Teacher changedTeacher)
  {
    TeacherList teachers = getAllTeachers();
    teachers.removeTeacher(teacher);
    teachers.addTeacher(changedTeacher);
    saveTeachers(teachers);
  }
  public void removeTeacher(Teacher teacher)
  {
    TeacherList teachers = getAllTeachers();
    teachers.removeTeacher(teacher);
    saveTeachers(teachers);
  }
}
