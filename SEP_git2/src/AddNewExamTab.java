import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.DatePicker;

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

  private ExamScheduleAdapter adapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   * @param adapter ExamScheduleAdapter object used for retrieving and storing exam information
   */
  public AddNewExamTab(String title, ExamScheduleAdapter adapter)
  {
    super(title);
    this.adapter=adapter;

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
  /*public void updateExamBox() is it useful???????
  {
    int currentIndex = examBox.getSelectionModel().getSelectedIndex();

    examBox.getItems().clear();

    ExamSchedule exams = adapter.getAllExams();
    for (int i = 0; i < exams.size(); i++)
    {
      examBox.getItems().add(exams.getAllExams().get(i));
    }

    if (currentIndex == -1 && examBox.getItems().size() > 0)
    {
      examBox.getSelectionModel().select(0);
    }
    else
    {
      examBox.getSelectionModel().select(currentIndex);
    }
  }*/

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
        MyDate date = new MyDate(datePicker.getValue().getDayOfMonth(), datePicker.getValue().getMonthValue(),datePicker.getValue().getYear());
        adapter.addExam(courseBox.getSelectionModel().getSelectedItem(),examinerBox.getSelectionModel().getSelectedItem(),
            roomBox.getSelectionModel().getSelectedItem(),date);
      }
    }
  }
}
