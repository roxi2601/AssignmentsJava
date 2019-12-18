import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;

/**
 * A GUI tab containing components for displaying a list of exams.
 *
 * @author Julia Tankiewicz
 * @version 1.0
 */

public class ExamTab extends Tab
{
  private HBox examsPane;
  private GridPane rightPane;

  private TableView<Exam> examsTable;
  private TableColumn<Exam, Course> courseColumn;
  private TableColumn<Exam, Teacher> examinerColumn;
  private TableColumn<Exam, MyDate> dateColumn;
  private TableColumn<Exam, String> roomNrColumn;
  private TableColumn<Exam, String> typeColumn;

  private Button getButton;
  private Button removeButton;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label typeLabel;
  private Label examLabel;

  private  ComboBox<Course> courseBox;
  private ComboBox<Teacher> examinerBox;
  private ComboBox<Room> roomBox;
  private RadioButton writtenButton;
  private RadioButton oralButton;
  private ComboBox<Exam> examBox;

  private Course allCourses;
  private Room allRooms;
  private Teacher allTeachers;


  private MyActionListener listener;

  private ExamScheduleAdapter examsAdapter;
  private CourseAdapter coursesAdapter;
  private RoomAdapter roomAdapter;
  private TeacherAdapter teachersAdapter;
  /**
   *constructor creating Exam tab object
   * @author Julia Tankiewicz
   */
  public ExamTab(String title)
  {
   super(title);

   this.examsAdapter = new ExamScheduleAdapter();
   this.coursesAdapter = new CourseAdapter();
   this.teachersAdapter = new TeacherAdapter();
   this.roomAdapter = new RoomAdapter();

   listener = new MyActionListener();

   examsTable=  new TableView<Exam>();
   examsTable.setPrefHeight(250);

    courseColumn = new TableColumn<Exam, Course>("Course");
    courseColumn.setCellValueFactory(new PropertyValueFactory<Exam, Course>("course"));
    courseColumn.setPrefWidth(150);

    examinerColumn = new TableColumn<Exam, Teacher>("Examiner");
    examinerColumn.setCellValueFactory(new PropertyValueFactory<Exam, Teacher>("examiner"));
    examinerColumn.setPrefWidth(170);

    dateColumn = new TableColumn<Exam, MyDate>("Date");
    dateColumn.setCellValueFactory(new PropertyValueFactory<Exam, MyDate>("date"));
    dateColumn.setPrefWidth(170);

    roomNrColumn = new TableColumn<Exam, String>("Room");
    roomNrColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("room"));
    roomNrColumn.setPrefWidth(100);

    typeColumn = new TableColumn<Exam, String>("Type");
    typeColumn.setCellValueFactory(new PropertyValueFactory<Exam,String>("type"));
    typeColumn.setPrefWidth(100);

    courseColumn.setReorderable(false);
    examinerColumn.setReorderable(false);
    dateColumn.setReorderable(false);
    roomNrColumn.setReorderable(false);
    courseColumn.setReorderable(false);

    examsTable.getColumns().addAll(courseColumn,examinerColumn,dateColumn,roomNrColumn,typeColumn);

    getButton  = new Button("Get schedule");
    getButton.setOnAction(listener);
    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    courseLabel = new Label("Course: ");
    examinerLabel = new Label("Examiner: ");
    roomLabel = new Label("Room: ");
    typeLabel = new Label("Type: ");
    examLabel = new Label("Exam: ");

    courseBox = new ComboBox<Course>();
    examinerBox = new ComboBox<Teacher>();
    roomBox = new ComboBox<Room>();
    writtenButton = new RadioButton("Written");
    oralButton = new RadioButton("Oral");
    examBox = new ComboBox<Exam>();

    rightPane = new GridPane();
    rightPane.setPadding(new Insets(10));
    rightPane.setHgap(5);
    rightPane.setVgap(5);
    rightPane.addRow(0,courseLabel,courseBox);
    rightPane.addRow(1,examinerLabel,examinerBox);
    rightPane.addRow(2,roomLabel,roomBox);
    rightPane.addRow(3,typeLabel,writtenButton,oralButton);
    rightPane.addRow(4);
    rightPane.addRow(5,examLabel,examBox);
    rightPane.addRow(6,removeButton, getButton);

    examsPane = new HBox(20);
    examsPane.getChildren().addAll(examsTable,rightPane);

    allCourses =  new Course("All",new Teacher("all","all"),new Room("all",0),"all",0);
    allTeachers =  new Teacher("All","all");
    allRooms =  new Room("All",0);

    super.setContent(examsPane);

  }
  /**
   *method updates exams table displaying exams given as parameter
   * @author Julia Tankiewicz
   */
  public void updateExamsTable(ExamSchedule exams)
  {
    examsTable.getItems().clear();
    for(int i = 0;i<exams.size();i++)
    {
      examsTable.getItems().add(exams.get(i));
    }
  }
  /**
   *method updates exam box
   * @author Julia Tankiewicz
   */
  public void updateExamBox()
  {
    int currentIndex = examBox.getSelectionModel().getSelectedIndex();

    examBox.getItems().clear();
    ExamSchedule exams = examsAdapter.getAllExams();
    System.out.println("Exams:" +exams.size());
    for (int i = 0; i < exams.size(); i++)
    {
      examBox.getItems().add(exams.get(i));
    }

    if (currentIndex == -1 && examBox.getItems().size() > 0)
    {
      examBox.getSelectionModel().select(0);
    }
    else
    {
      examBox.getSelectionModel().select(currentIndex);
    }
  }
  /**
   *method update course box
   * @author Julia Tankiewicz
   */
  public void updateCourseBox()
  {
    int currentIndex = courseBox.getSelectionModel().getSelectedIndex();
    courseBox.getItems().clear();
    courseBox.getItems().add(allCourses);
    CourseList courses = coursesAdapter.getAllCourses();
    for (int i = 0; i < courses.size(); i++)
    {
      courseBox.getItems().add(courses.getCourse(i));
    }

    if (currentIndex == -1 && courseBox.getItems().size() > 0)
    {
      courseBox.getSelectionModel().select(0);
    }
    else
    {
      courseBox.getSelectionModel().select(currentIndex);
    }
  }
  /**
   *method update room box
   * @author Julia Tankiewicz
   */
  public void updateRoomBox()
  {
    int currentIndex = roomBox.getSelectionModel().getSelectedIndex();

    roomBox.getItems().clear();
    roomBox.getItems().add(allRooms);
    RoomList rooms= roomAdapter.getAllRooms();
    for (int i = 0; i < rooms.size(); i++)
    {
      roomBox.getItems().add(rooms.getRoom(i));
    }

    if (currentIndex == -1 && roomBox.getItems().size() > 0)
    {
      roomBox.getSelectionModel().select(0);
    }
    else
    {
      roomBox.getSelectionModel().select(currentIndex);
    }
  }
  /**
   *method update examiner box
   * @author Julia Tankiewicz
   */
  public void updateExaminerBox()
  {
    int currentIndex = examinerBox.getSelectionModel().getSelectedIndex();

    examinerBox.getItems().clear();
    examinerBox.getItems().add(allTeachers);
    TeacherList examiners= teachersAdapter.getAllTeachers();
    for (int i = 0; i < examiners.size(); i++)
    {
      examinerBox.getItems().add(examiners.getTeacher(i));
    }

    if (currentIndex == -1 && examinerBox.getItems().size() > 0)
    {
      examinerBox.getSelectionModel().select(0);
    }
    else
    {
      examinerBox.getSelectionModel().select(currentIndex);
    }
  }

  /**
   * private class listener gives functionality to buttons
   * @author Julia Tankiewicz
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource()==getButton)
      {
        ExamSchedule temp = examsAdapter.getAllExams();
        for(int i = 0;i<temp.size();i++)
        {
          if(courseBox.getSelectionModel().getSelectedItem()!=null&& !(courseBox.getSelectionModel().getSelectedItem().equals(allCourses)) && !temp.get(i).getCourse().equals(courseBox.getSelectionModel().getSelectedItem()))
          {
            temp.removeExam(temp.get(i));
          }
          if(roomBox.getSelectionModel().getSelectedItem()!=null&&!(roomBox.getSelectionModel().getSelectedItem().equals(allRooms)) && !temp.get(i).getRoom().equals(roomBox.getSelectionModel().getSelectedItem()))
          {
            temp.removeExam(temp.get(i));
          }
          if( examinerBox.getSelectionModel().getSelectedItem()!=null &&!(examinerBox.getSelectionModel().getSelectedItem().equals(allTeachers)) && !temp.get(i).getExaminer().equals(examinerBox.getSelectionModel().getSelectedItem()))
          {
            temp.removeExam(temp.get(i));
          }
          if(temp!=null&& oralButton.isSelected()&& temp.get(i).getType().equals("Written"))
          {
            temp.removeExam(temp.get(i));
          }
          if(temp!=null && writtenButton.isSelected()&&  temp.get(i).getType().equals("Oral"))
          {
            temp.removeExam(temp.get(i));
          }
        }
        updateExamsTable(temp);
      }
      else if(e.getSource()==removeButton)
      {
        ExamSchedule temp = examsAdapter.getAllExams();
        if (temp.size() > 1)
        {
          for (int i = 0; i < temp.size(); i++)
          {
            if (temp.get(i).equals(examBox.getSelectionModel().getSelectedItem()))
            {
              temp.removeExam(temp.get(i));
            }
          }
          examsAdapter.saveExamSchedule(temp);
          updateExamsTable(temp);
        }
        else
        {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setHeaderText(null);
          alert.setTitle("Info");
          alert.setContentText("Last exam cannot be removed");
          alert.showAndWait();
        }
      }
    }
  }
}





