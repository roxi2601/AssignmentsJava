import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  A class to handle input and output streams for Courses.
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class CourseAdapter
{
  private MyFileIO mfio;
  private String fileName;

  public CourseAdapter(){
    mfio = new MyFileIO();
    fileName = "sep/courses.bin";
  }
  public CourseList getAllCourses()
  {
    CourseList courses = new CourseList();
    try
    {
      courses = (CourseList) mfio.readObjectFromFile(fileName);
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return courses;
  }
  public  void saveCourses(CourseList courses)
  {
    try
    {
      mfio.writeToFile(fileName,courses);
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
  public void addCourse(Course course)
  {
    CourseList courses = getAllCourses();
    courses.addCourse(course);
    saveCourses(courses);
  }
  public void removeCourse(Course course)
  {
    CourseList courses = getAllCourses();
    for(int i = 0;i<courses.size();i++)
    {
      if(courses.getCourse(i).equals(course))
      {
        courses.removeCourse(i);
      }
    }
    saveCourses(courses);
  }
  public void changeCourse(Course course, Course changedCourse)
  {
    CourseList courses = getAllCourses();
    for(int i = 0;i<courses.size();i++)
    {
      if(courses.getCourse(i).equals(course))
      {
        courses.removeCourse(i);
        courses.addCourse(changedCourse);
      }
    }
    saveCourses(courses);
  }
}
