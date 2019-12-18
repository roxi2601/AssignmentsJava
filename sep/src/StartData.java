import java.util.ArrayList;
/**
 *class adds first objects to files and creates first exam
 * @author Julia Tankiewicz
 */
public class StartData
  {
    public static void main(String[] args)
    {
      Teacher teacher = new Teacher("Allan","alhe@via.dk");
      Room room = new Room("E.101a",0);
      MyDate md = new MyDate(0,0,0);
      Course course=new Course("SDJ1X",teacher, room,"Oral",0);
      Exam exam  = new Oral(course, teacher,md, room);

      TeacherList tl = new TeacherList();
      tl.addTeacher(teacher);
      RoomList rl = new RoomList();
      rl.addRoom(room);
      ExamSchedule es = new ExamSchedule();
      es.addExam(exam);
      CourseList cl = new CourseList();
      cl.addCourse(course);

      MyFileIO mfio = new MyFileIO();

      try
      {
        mfio.writeToFile("sep/rooms.bin", rl);
        mfio.writeToFile("sep/teachers.bin", tl);
        mfio.writeToFile("sep/courses.bin", cl);
        mfio.writeToFile("sep/exams.bin", es);
      }
      catch (Exception e)
      {
        System.out.println("Writing to file went wrong");
      }

    }
}
