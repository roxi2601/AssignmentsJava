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
public class MenageCourseDataTab extends Tab
{
  private VBox changeCoursePane;
  private HBox changeCourseTopPane;
  private FlowPane comboPane;

  private Label courseNameLabel;
  private Label examLabel;
  private Label teacherLabel;
  private Label roomLabel;
  private Label dateLabel;

  private GridPane changeCourseInputPane;

  private ComboBox<ExamSchedule> examBox;
  private TextField courseNameField;
  private TextField examField;
  private TextField teacherField;
  private TextField roomField;
  private TextField dateField;

  private FlowPane imagePane;
  private Image logo;
  private ImageView logoView;

  private Button updateButton;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  public MenageCourseDataTab(String title, ExamScheduleAdapter adapter)
  {
    super(title);

    this.adapter = adapter;

    listener = new MyActionListener();

    updateButton = new Button("Update");
    updateButton.setOnAction(listener);

    changeCoursePane = new VBox(20);
    changeCoursePane.setPadding(new Insets(10));

    changeCourseTopPane = new HBox(20);

    examBox=new ComboBox<ExamSchedule>();
    examBox.setOnAction(listener);

    comboPane = new FlowPane();
    comboPane.setAlignment(Pos.BASELINE_RIGHT);
    comboPane.setPrefWidth(200);
    comboPane.getChildren().add(examBox);

    courseNameLabel=new Label("Course name:");
    examLabel=new Label("Exam type:");
    teacherLabel=new Label("Examiner:");
    roomLabel=new Label("Room number:");
    dateLabel=new Label("Date");

    courseNameField=new TextField();
    examField=new TextField();
    examField.setEditable(false);
    teacherField=new TextField();
    teacherField.setEditable(false);
    roomField=new TextField();
    roomField.setEditable(false);
    dateField=new TextField();
    dateField.setEditable(false);

    changeCourseInputPane = new GridPane();
    changeCourseInputPane.setHgap(5);
    changeCourseInputPane.setVgap(5);

    changeCourseInputPane.addRow(0, courseNameLabel, courseNameField);
    changeCourseInputPane.addRow(1, examLabel, examField);
    changeCourseInputPane.addRow(2, teacherLabel, teacherField);
    changeCourseInputPane.addRow(3, roomLabel, roomField);
    changeCourseInputPane.addRow(4, dateLabel, dateField);

    changeCourseInputPane.getChildren().add(changeCourseInputPane);
    changeCourseInputPane.getChildren().add(comboPane);

    logo=new Image("vialogoah.gif");
    logoView=new ImageView(logo);
    imagePane = new FlowPane();
    imagePane.setPrefHeight(200);
    imagePane.setAlignment(Pos.BOTTOM_CENTER);
    imagePane.getChildren().add(logoView);

    changeCoursePane.getChildren().add(changeCourseTopPane);
    changeCoursePane.getChildren().add(updateButton);
    changeCoursePane.getChildren().add(imagePane);

    super.setContent(changeCoursePane);
  }
  public void changeEditableState(boolean bool)
  {
    examField.setEditable(bool);
    teacherField.setEditable(bool);
    roomField.setEditable(bool);
    dateField.setEditable(bool);
  }

  public void updateExamBox()
  {
    int currentIndex = examBox.getSelectionModel().getSelectedIndex();

    examBox.getItems().clear();

    ExamSchedule exams = adapter.getAllExams();
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
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if (e.getSource() == updateButton)
      {
        String courseName = courseNameField.getText();
        String exam = examField.getText();
        String teacher = teacherField.getText();
        String room = roomField.getText();
        String date = dateField.getText();

        if (courseName.equals(""))
        {
          courseName = "?";
        }

        adapter.changeCourse(courseName, exam, teacher, room, date);
        updateExamBox();
        courseNameField.setText("");
      }
      else if (e.getSource() == examBox)
      {
        Exam temp = examBox.getSelectionModel().getSelectedItem();

        if (temp != null)
        {
          courseNameField.setText(String.valueOf(temp.getCourse()));
          examField.setText(String.valueOf(temp.getType())); //??????
          teacherField.setPromptText(String.valueOf(temp.getExaminer()));
          roomField.setPromptText(String.valueOf(temp.getRoom()));
          dateField.setPromptText(String.valueOf(temp.getDate()));
        }
      }
    }
  }

}
