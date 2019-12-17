import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * A GUI tab containing components for adding new exam.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class AddNewExamTab extends Tab
{
  private VBox addNewExamTab;

  private GridPane examPane;

  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;

  private Button addButton;

  private ComboBox<Course>courseBox;
  private ComboBox<Room>roomBox;
  private ComboBox<Teacher>examinerBox;

  private Label courseBoxLabel;
  private Label roomBoxLabel;
  private Label examinerBoxLabel;
  private Label dateLabel;

  private DatePicker datePicker;

  private MyActionListener listener;

  private ExamScheduleAdapter examScheduleAdapter;
  private CourseAdapter courseAdapter;
  private RoomAdapter roomAdapter;
  private TeacherAdapter teacherAdapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   */
  public AddNewExamTab(String title)
  {
    super(title);
    this.examScheduleAdapter= new ExamScheduleAdapter();
    this.courseAdapter = new CourseAdapter();
    this.roomAdapter = new RoomAdapter();
    this.teacherAdapter = new TeacherAdapter();

    listener = new MyActionListener();

    addNewExamTab = new VBox(20);

    examPane = new GridPane();
    examPane.setHgap(5);
    examPane.setVgap(5);

    dateLabel = new Label("Date:");
    courseBoxLabel = new Label("Course");
    examinerBoxLabel = new Label("Examiner:");
    roomBoxLabel = new Label("Room:");

    datePicker = new DatePicker();
    courseBox = new ComboBox<>();
    examinerBox = new ComboBox<>();
    roomBox = new ComboBox<>();


    examPane.addRow(0, dateLabel, datePicker);
    examPane.addRow(1, courseBoxLabel, courseBox);
    examPane.addRow(2,examinerBoxLabel, examinerBox);
    examPane.addRow(3, roomBoxLabel, roomBox);

    addButton = new Button("Add");
    addButton.setOnAction(listener);

    logo = new Image("file:vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);

    addNewExamTab.getChildren().add(examPane);
    addNewExamTab.getChildren().add(addButton);
    addNewExamTab.getChildren().add(imagePane);

    super.setContent(addNewExamTab);
  }

  public void updateCourseBox()
  {
    int currentIndex = courseBox.getSelectionModel().getSelectedIndex();
    courseBox.getItems().clear();
    CourseList courses = courseAdapter.getAllCourses();
    for (int i = 0; i < courses.size(); i++)
    {
      courseBox.getItems().add(courses.getAllCourses().get(i));
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
  public void updateRoomBox()
  {
    int currentIndex = roomBox.getSelectionModel().getSelectedIndex();

    roomBox.getItems().clear();
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
  public void updateExaminerBox()
  {
    int currentIndex = examinerBox.getSelectionModel().getSelectedIndex();

    examinerBox.getItems().clear();
    TeacherList examiners= teacherAdapter.getAllTeachers();
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
  /*
   * Inner action listener class
   * @author Roksana Dziadowicz
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if (e.getSource() == addButton)
      {
        int day = datePicker.getValue().getDayOfMonth();
        int month  = datePicker.getValue().getMonthValue();
        int year = datePicker.getValue().getYear();

        MyDate date = new MyDate(day,month,year);
        Course course = courseBox.getSelectionModel().getSelectedItem();
        Teacher examiner = examinerBox.getSelectionModel().getSelectedItem();
        Room room = roomBox.getSelectionModel().getSelectedItem();

        examScheduleAdapter.addExam(course, examiner, room, date);

      }
    }
  }
}
