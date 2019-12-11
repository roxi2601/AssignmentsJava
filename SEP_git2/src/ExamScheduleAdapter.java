import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A class containing ExamScheduleAdapter objects and methods
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class ExamScheduleAdapter
{
  private MyFileIO mfio;
  private String fileName;

  public ExamScheduleAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;
  }

  // Use the MyFileIO class to retrieve a CourseList object with all Students
  public ExamSchedule getAllExams()
  {
    ExamSchedule examSchedule = new ExamSchedule();

    try
    {
      examSchedule = (ExamSchedule)mfio.readObjectFromFile(fileName);
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
    return examSchedule;
  }
  //method saves the updated exam schedule and writes it to file
  public void saveExamSchedule(ExamSchedule exams)
  {
    try
    {
      mfio.writeToFile(fileName, exams);
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
  public void addExam(Course course, Teacher examiner, Room room, MyDate date)
  {
    ExamSchedule exams = getAllExams();
    boolean canBeAdded = true;

    for(int i = 0;i< exams.size();i++)
    {
      if(exams.getExam(i).getDate().equals(date) && exams.getExam(i).getRoom().equals(room))
      {
        canBeAdded = false;
      }
    }
    if(course.getExamType().equals("Oral"))
    {
      if(course.getTeacher().equals(examiner))
      {
        canBeAdded=false;
      }
      exams.addExam(new Oral(course, examiner, date, room));
    }
    else if(course.getExamType().equals("Written"))
    {
      exams.addExam(new Written(course, examiner, date, room));
    }
    saveExamSchedule(exams);
  }
  public void removeExam(MyDate date, Room room)
  {
    ExamSchedule exams = getAllExams();
    for(int i = 0;i<exams.size();i++)
    {
      if(exams.getExam(i).getRoom().equals(room) && exams.getExam(i).getDate().equals(date))
      {
        exams.removeExam(exams.getExam(i));
      }
    }
    saveExamSchedule(exams);
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
  public void changeDate(Course course, MyDate date, Room room)
  {
    ExamSchedule exams = getAllExams();
    boolean canBeReserved = true;
    for(int j = 0;j<exams.size();j++)
    {
      if(exams.getExam(j).getDate().equals(date)&& exams.getExam(j).getRoom().equals(room))
      {
        canBeReserved = false;
      }
    }
    for (int i = 0; i < exams.size(); i++)
    {
      if(exams.getExam(i).getCourse().equals(course) && exams.getExam(i).getRoom().equals(room));
      {
        exams.getExam(i).setDate(date);
      }
    }
    saveExamSchedule(exams);
  }
  public void changeExaminer(Teacher examiner,MyDate date, Room room)
  {
    ExamSchedule exams = getAllExams();
    boolean canBeReserved = true;
    for(int j = 0;j<exams.size();j++)
    {
      if(exams.getExam(j).getExaminer().equals(examiner)&& exams.getExam(j).getDate().equals(date))
      {
        canBeReserved = false;
      }
    }
    for (int i = 0; i < exams.size(); i++)
    {
      if(exams.getExam(i).getDate().equals(date) && exams.getExam(i).getRoom().equals(room));
      {
        exams.getExam(i).setExaminer(examiner);
      }
    }
    saveExamSchedule(exams);
  }
  public void changeRoom(Course course,MyDate date, Room room)
  {
    boolean canBeReserved = true;
    ExamSchedule exams = getAllExams();
    for(int j = 0;j<exams.size();j++)
    {
      if(exams.getExam(j).getRoom().equals(room)&& exams.getExam(j).getDate().equals(date)&&course.getExamType().equals("Oral"))
      {
        canBeReserved = false;
      }
    }
    for (int i = 0; i < exams.size(); i++)
    {
      if(exams.getExam(i).getDate().equals(date) && exams.getExam(i).getCourse().equals(course)&& canBeReserved);
      {
        exams.getExam(i).reserveRoom(room);
      }
    }
    saveExamSchedule(exams);
  }
}




