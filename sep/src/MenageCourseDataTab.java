import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A GUI tab containing components for changing course.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class MenageCourseDataTab extends Tab
{
  private HBox manegeCourseDataTab;

  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;


  private  GridPane courseData;
  private VBox allCourseData;
  private HBox addAndRemoveButtons;

  private Button addButton;
  private Button removeButton;

  private CheckBox newCourseCheckBox;

  private ComboBox<Course>courseBox;
  private ComboBox<Teacher>teacherBox;
  private ComboBox<String>typeBox;
  private ComboBox<Room>roomBox;

  private Label courseLabel;
  private Label courseNameLabel;
  private Label teacherLabel;
  private Label roomLabel;
  private Label typeLabel;
  private Label numberOfStudentsLabel;

  private TextField courseNameField;
  private TextField numberOfStudentsField;

  private Course newCourse;

  private MyActionListener listener;

  private CourseAdapter adapter;
  private TeacherAdapter teacherAdapter;
  private RoomAdapter roomAdapter;
  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   */
  public MenageCourseDataTab(String title)
  {
    super(title);
    this.adapter=new CourseAdapter();
    this.teacherAdapter = new TeacherAdapter();
    this.roomAdapter = new RoomAdapter();
    listener = new MyActionListener();

    manegeCourseDataTab = new HBox(20);

    allCourseData = new VBox(20);

    courseLabel = new Label("Course:");
    courseBox = new ComboBox<Course>();
    courseBox.setOnAction(listener);

    courseNameLabel = new Label("Course name:");
    courseNameField = new TextField();

    teacherLabel = new Label("Teacher:");
    teacherBox = new ComboBox<Teacher>();

    roomLabel = new Label("Room:");
    roomBox = new ComboBox<Room>();

    typeLabel = new Label("Exam type:");
    typeBox = new ComboBox<String>();
    typeBox.getItems().add("Written");
    typeBox.getItems().add("Oral");

    numberOfStudentsLabel = new Label("Number of students:");
    numberOfStudentsField = new TextField();

    addAndRemoveButtons = new HBox(20);
    addButton = new Button("Add/Change");
    addButton.setOnAction(listener);
    newCourseCheckBox = new CheckBox("New course");
    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);
    addAndRemoveButtons.getChildren().add(newCourseCheckBox);

    courseData = new GridPane();
    courseData.setHgap(5);
    courseData.setVgap(5);
    courseData.addRow(0,courseLabel, courseBox);
    courseData.addRow(1, courseNameLabel, courseNameField);
    courseData.addRow(2, teacherLabel, teacherBox);
    courseData.addRow(3, roomLabel, roomBox);
    courseData.addRow(4, typeLabel, typeBox);
    courseData.addRow(5, numberOfStudentsLabel, numberOfStudentsField);

    allCourseData.getChildren().add(courseData);
    allCourseData.getChildren().add(addAndRemoveButtons);

    logo = new Image("file:vialogoah.gif");
    logoView = new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);

    manegeCourseDataTab.getChildren().add(allCourseData);
    manegeCourseDataTab.getChildren().add(imagePane);

    super.setContent(manegeCourseDataTab);
  }
  /**
   * Updates the courseBox ComboBox with information from the courses file
   */
  public void updateCourseBox()
  {
    int currentIndex = courseBox.getSelectionModel().getSelectedIndex();

    courseBox.getItems().clear();

    CourseList courses = adapter.getAllCourses();
    for (int i = 0; i < courses.size(); i++)
    {
      courseBox.getItems().add(courses.getAllCourses().get(i));
    }


  /*  if (currentIndex == -1 && courseBox.getItems().size() > 0)
    {
      courseBox.getSelectionModel().select(0);
    }
    else
    {
      courseBox.getSelectionModel().select(currentIndex);
    }
    */

  courseBox.getSelectionModel().selectFirst();
    System.out.println("!"+courseBox.getSelectionModel().getSelectedItem());
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
    int currentIndex = teacherBox.getSelectionModel().getSelectedIndex();

    teacherBox.getItems().clear();
    TeacherList examiners= teacherAdapter.getAllTeachers();
    for (int i = 0; i < examiners.size(); i++)
    {
      teacherBox.getItems().add(examiners.getTeacher(i));
    }

    if (currentIndex == -1 && teacherBox.getItems().size() > 0)
    {
      teacherBox.getSelectionModel().select(0);
    }
    else
    {
      teacherBox.getSelectionModel().select(currentIndex);
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
      if(e.getSource() == addButton)
      {
        Course temp = courseBox.getSelectionModel().getSelectedItem();
        String courseName = courseNameField.getText();
        Teacher teacher = teacherBox.getSelectionModel().getSelectedItem();
        Room room = roomBox.getSelectionModel().getSelectedItem();
        String examType = typeBox.getSelectionModel().getSelectedItem();
        int numberOfStudents=0;
        if(numberOfStudentsField.getText().isEmpty() || numberOfStudentsField.getText().contains("[a-zA-Z]+")==true)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setHeaderText(null);
          alert.setTitle("Warning");
          alert.setContentText("Number of students cannot contain letters or be empty, please type only number :)");
          alert.showAndWait();
        }
        else
        {
          numberOfStudents = Integer.parseInt(numberOfStudentsField.getText());
        }
        Course course = new Course(courseName,teacher,room,examType,numberOfStudents);
        if(newCourseCheckBox.isSelected())
        {
          adapter.addCourse(course);
        }
        else
        {
          adapter.changeCourse(temp, course);
        }
        updateCourseBox();
      }
      else if(e.getSource() == removeButton)
      {
        Course temp = courseBox.getSelectionModel().getSelectedItem();
        if(newCourseCheckBox.isSelected())
        {
        //  removeButton.setDisable(true);
        }
        else
        {
          adapter.removeCourse(temp);
        }
      }
      else if(e.getSource()==courseBox)
      {
        Course temp = courseBox.getSelectionModel().getSelectedItem();
        System.out.println(temp);
        if(temp!=null)
        {
          if (newCourseCheckBox.isSelected())
          {
            courseNameField.setEditable(true);
            courseNameField.setText("");
            numberOfStudentsField.setText("");
          }
          else
          {
            courseNameField.setText(temp.getName());
            teacherBox.getSelectionModel().select(temp.getTeacher());
            roomBox.getSelectionModel().select(temp.getRoom());
            typeBox.getSelectionModel().select(temp.getExamType());
            numberOfStudentsField.setText(temp.getNumberOfStudents() + "");
          }
        }
      }
    }
  }

}