import java.util.ArrayList;

public class ExamSchedule
{
  private ArrayList<Exam> exams;

  public ExamSchedule()
  {
    exams = new ArrayList<Exam>();
  }

  public ArrayList<Exam> getAllExams()
  {
    return exams;
  }

  public ArrayList<Exam> getAllExams(String courseName) //???
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getCourse().equals(courseName)))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }

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
  public void editExam(Exam exam) //????????
  {

  }
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }
  public void removeExam(Exam exam)
  {
    exams.remove(exam);
  }
  public String toString()
  {
    String str="";
    for(int i=0;i<exams.size();i++)
    {
      str+="Course:"+exams.get(i).getCourse()+"Type of the exam:"+exams.get(i).getType()+"Examiner:"+exams.get(i).getExaminer()+""
          + "Room:"+exams.get(i).getRoom()+" Date:"+exams.get(i).getDate();
    }
    return str;
  }
}
