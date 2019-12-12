import java.io.FileNotFoundException;
import java.io.IOException;

public class TeacherAdapter
{
  private  MyFileIO mfio;
  private String fileName;

  public TeacherAdapter()
  {
    mfio = new MyFileIO();
    this.fileName = "teachers.bin";
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
    TeacherList teachers = new TeacherList();
    try
    {
      teachers = (TeacherList)mfio.readObjectFromFile(fileName);
      for(int i = 0;i<teachers.size();i++)
      {
        if(teachers.getTeacher(i).equals(teacher))
        {
          teachers.addTeacher(teacher);
        }
      }
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
    saveTeachers(teachers);
  }
  public void changeTeacher(Teacher teacher,Teacher changedTeacher)
  {
    TeacherList teachers = new TeacherList();
    try
    {
      teachers = (TeacherList)mfio.readObjectFromFile(fileName);
      for(int i = 0;i<teachers.size();i++)
      {
        if(teachers.getTeacher(i).equals(teacher))
        {
          teachers.removeTeacher(i);
          teachers.addTeacher(changedTeacher);
        }
      }
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
    saveTeachers(teachers);
  }
  public void removeTeacher(Teacher teacher)
  {
    TeacherList teachers = new TeacherList();
    try
    {
      teachers = (TeacherList)mfio.readObjectFromFile(fileName);
      for(int i = 0;i<teachers.size();i++)
      {
        if(teachers.getTeacher(i).equals(teacher))
        {
          teachers.removeTeacher(i);
        }
      }
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
    saveTeachers(teachers);
  }
}
