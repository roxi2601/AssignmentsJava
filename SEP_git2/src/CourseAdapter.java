import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  A class to handle input and output streams for Courses.
 * @author Prabhjot Singh
 * @version 1.0
 */
public class CourseAdapter
{
  private MyFileIO fileIO;
  private String fileName;

  public CourseAdapter(){
    fileIO = new MyFileIO();
    fileName = "coursedata.bin";
  }

  public void addObject(Course obj){
    try
    {
      fileIO.writeToFile(fileName, obj);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error writing to file");
    }
  }
  public void changeCourse(Course course,MyDate date, Room room)
  {
    ExamSchedule exams = getAllExams();

    for (int i = 0; i < exams.size(); i++)
    {
      if(exams.getExam(i).getDate().equals(date) && exams.getExam(i).getRoom().equals(room));
      {
        exams.getExam(i).setCourse(course);
      }
    }
    saveExamSchedule(exams);
  }

  public CourseList getAllCourses(){
    CourseList courses = new CourseList();
    try
    {
      courses = (CourseList) fileIO.readObjectFromFile(fileName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return courses;
  }
}
