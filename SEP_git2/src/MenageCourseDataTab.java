import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
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

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   */
  public MenageCourseDataTab(String title)
  {
    super(title);
    this.adapter=new CourseAdapter();
    listener = new MyActionListener();
    newCourse =  new Course("New",null,null,"",0);

    manegeCourseDataTab = new HBox(20);

    allCourseData = new VBox(20);

    courseLabel = new Label("Course:");
    courseBox = new ComboBox<Course>();
    courseBox.setOnAction(listener);

    courseNameLabel = new Label("Course name:");
    courseNameField = new TextField();
    courseNameField.setEditable(false);

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
    addButton = new Button("Add");
    addButton.setOnAction(listener);
    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);

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
    courseBox.getItems().add(newCourse);
    CourseList courses = adapter.getAllCourses();
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
        int numberOfStudents = Integer.parseInt(numberOfStudentsField.getText());
        Course course = new Course(courseName,teacher,room,examType,numberOfStudents);
        if(temp.equals(newCourse))
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
        if(temp.equals(newCourse))
        {
          removeButton.setDisable(true);
        }
        else
        {
          adapter.removeCourse(temp);
        }
      }
      else if(e.getSource()==courseBox)
      {
        Course temp = courseBox.getSelectionModel().getSelectedItem();
        if(temp.equals(newCourse))
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
          numberOfStudentsField.setText(temp.getNumberOfStudents()+"");
        }
      }
    }
  }

}