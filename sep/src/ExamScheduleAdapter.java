import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A class containing ExamScheduleAdapter objects and methods
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class ExamScheduleAdapter
{
  private MyFileIO mfio;
  private String fileName;

  public ExamScheduleAdapter()
  {
    mfio = new MyFileIO();
    this.fileName = "sepfinal/exams.bin";
  }

  // Use the MyFileIO class to retrieve a CourseList object with all Students
  public ExamSchedule getAllExams()
  {
    ExamSchedule examSchedule = new ExamSchedule();

    try
    {
      examSchedule = (ExamSchedule)mfio.readObjectFromFile(fileName);
    }catch(Exception e){
      System.out.println("Exception: " + e);
    }
    return examSchedule;
  }
  /**
   *method saves the updated exam schedule and writes it to file
   * @author Julia Tankiewicz
   */
  public void saveExamSchedule(ExamSchedule exams)
  {
    try
    {
      mfio.writeToFile(fileName, exams);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found" + e);
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }
  /**
   *method adds new exam to external file with all exams
   * @author Julia Tankiewicz
   */
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
    if(course.getExamType().equals("Oral")&& canBeAdded && course.getRoom().equals(room))
    {
      exams.addExam(new Oral(course, examiner, date, room));
    }
    else if(course.getExamType().equals("Written")&& canBeAdded)
    {
      exams.addExam(new Written(course, examiner, date, room));
    }
    saveExamSchedule(exams);
  }
  /**
   *method removes exam from file which matches with one given as parameter
   * @author Julia Tankiewicz
   */
  public void removeExam(Exam exam)
  {
    ExamSchedule exams = getAllExams();
    for(int i = 0;i<exams.size();i++)
    {
      if(exams.getExam(i).equals(exam))
      {
        exams.removeExam(exam);
      }
    }
    saveExamSchedule(exams);
  }
  /**
   *method changes date of exam from file matching with one given as parameter
   * @author Julia Tankiewicz
   */
  public boolean changeDate(Exam exam, MyDate date)
  {
    ExamSchedule exams = getAllExams();
    boolean canBeReserved = true;
    for(int i = 0;i<exams.size();i++)
    {
      if(exams.getExam(i).getRoom().equals(exam.getRoom()) && exams.getExam(i).getDate().equals(date))
      {
        canBeReserved = false;
        break;
      }
    }
    if(canBeReserved)
    {
      for (int i = 0; i < exams.size(); i++)
      {
        if(exams.get(i).equals(exam))
        {
          exams.get(i).setDate(date);
        }
      }
    }
    saveExamSchedule(exams);
    return canBeReserved;
  }
  /**
   *method changes examiner for the exam from file matching with one given as parameter
   * @author Julia Tankiewicz
   */
  public void changeExaminer(Exam exam, Teacher changedExaminer)
  {
    ExamSchedule exams  =getAllExams();
    boolean canBeChanged = true;
    for(int i = 0;i<exams.size();i++)
    {
      if(exams.getExam(i).getDate().equals(exam.getDate())&& exams.getExam(i).getExaminer().equals(changedExaminer))
      {
        canBeChanged=false;
      }
    }
    if(changedExaminer.getUnavailability().contains(exam.getDate()))
    {
      canBeChanged=false;
    }
    for(int i = 0;i<exams.size();i++)
    {
      if(exams.getExam(i).equals(exam)&& canBeChanged)
      {
        exams.getExam(i).setExaminer(changedExaminer);
      }
    }
    saveExamSchedule(exams);
  }
  /**
   *method changes room for the exam from file matching with one given as parameter
   * @author Julia Tankiewicz
   */
  public void changeRoom(Exam exam, Room room)
  {
    boolean canBeChanged = true;
    ExamSchedule exams = getAllExams();
    for(int j = 0;j<exams.size();j++)
    {
      if(exams.getExam(j).getRoom().equals(room) && exams.getExam(j).getDate().equals(exam.getDate()) && exam.getNumberOfStudents()>room.getSeatsCapacity())
      {
        canBeChanged = false;
      }
    }
    for (int i = 0; i < exams.size(); i++)
    {
      if(exams.getExam(i).equals(exam)&&canBeChanged);
      {
        exams.getExam(i).reserveRoom(room);
      }
    }
    saveExamSchedule(exams);
  }

  /**
   * method generates xml file and saves it in proper place
   */
  public void generateXMLfile()
  {
    ExamSchedule exams = getAllExams();
    PrintWriter write = null;
    try
    {
      FileOutputStream fileOut = new FileOutputStream("C:/Users/HUAWEI/Desktop/SEP1 final/source code/SEBWEB/exams.xml");
      write = new PrintWriter(fileOut);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    write.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    write.println("<students>");
    for(int i =0;i<exams.size();i++)
    {
      write.println("<exam>");
      write.println("<course>"+exams.get(i).getCourse()+"</course>");
      write.println("<examiner>"+exams.get(i).getExaminer()+"</examiner>");
      write.println("<date>"+exams.get(i).getDate()+"</date>");
      write.println("<room>"+exams.get(i).getRoom()+"</room>");
      write.println("<type>"+exams.get(i).getType()+"</type>");
      write.println("</exam>");
    }
    write.println("</students>");
    write.close();
  }
}




