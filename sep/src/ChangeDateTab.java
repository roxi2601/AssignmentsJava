import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A GUI tab containing components for changing a exam's date.
 * @author Julia Tankiewicz and Roksana Dziadowicz
 * @version 1.0
 */
public class ChangeDateTab extends Tab
{
  private HBox changeDatePane; //all

  private VBox examPane; // left
  private VBox datePane; //right

  private DatePicker datePicker;

  private ComboBox<Exam>examBox;

  private GridPane changeDateChoosePane; //right
  private GridPane examDataPane; //left

  private Button updateButton;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField dayField;
  private TextField monthField;
  private TextField yearField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label dayLabel;
  private Label monthLabel;
  private Label yearLabel;
  private Label datePickerLabel;

  private MyActionListener listener;

  private ExamScheduleAdapter adapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   */
  public ChangeDateTab(String title)
  {
    super(title);
    this.adapter=new ExamScheduleAdapter();

    listener = new MyActionListener();

    changeDatePane = new HBox(20);

    //exam data-start
    examPane = new VBox(20);
    examPane.setPrefWidth(200);

    examBox = new ComboBox<Exam>();
    examBox.setOnAction(listener);

    roomLabel = new Label("Room:");
    courseLabel = new Label("Course");
    examinerLabel = new Label("Examiner:");
    dateLabel = new Label ("Date:");

    roomField = new TextField();
    roomField.setEditable(false);
    courseField = new TextField();
    courseField.setEditable(false);
    examinerField = new TextField();
    examinerField.setEditable(false);
    dateField = new TextField();
    dateField.setEditable(false);

    examDataPane = new GridPane();
    examDataPane.setHgap(5);
    examDataPane.setVgap(5);
    examDataPane.addRow(0, examinerLabel, examinerField);
    examDataPane.addRow(1, courseLabel, courseField);
    examDataPane.addRow(2, roomLabel, roomField);
    examDataPane.addRow(3, dateLabel, dateField);

    examPane.getChildren().add(examBox);
    examPane.getChildren().add(examDataPane);
    //exam data-end

    //date-start
    datePane = new VBox(20);
    datePane.setPrefWidth(200);

    datePicker = new DatePicker();
    datePicker.setOnAction(listener);
    datePickerLabel = new Label("Date:");
    dayLabel = new Label("Day:");
    monthLabel = new Label("Month:");
    yearLabel = new Label ("Year:");

    dayField=new TextField();
    dayField.setEditable(false);
    monthField=new TextField();
    monthField.setEditable(false);
    yearField=new TextField();
    yearField.setEditable(false);

    changeDateChoosePane = new GridPane();
    changeDateChoosePane.setVgap(5);
    changeDateChoosePane.setHgap(5);
    changeDateChoosePane.addRow(0, datePickerLabel, datePicker);
    changeDateChoosePane.addRow(1, dayLabel, dayField);
    changeDateChoosePane.addRow(2,monthLabel,monthField);
    changeDateChoosePane.addRow(3, yearLabel,yearField);

    updateButton = new Button("Update");
    updateButton.setOnAction(listener);

    datePane.getChildren().add(changeDateChoosePane);
    datePane.getChildren().add(updateButton);
    //date-end

    changeDatePane.getChildren().add(examPane);
    changeDatePane.getChildren().add(datePane);

    super.setContent(changeDatePane);
  }
  /**
   *method updates exam box
   * @author Julia Tankiewicz
   */
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
  /*
   * Inner action listener class
   * @author Roksana Dziadowicz
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource() == updateButton)
      {
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        MyDate date  = new MyDate(day, month,year);
        Exam exam = examBox.getSelectionModel().getSelectedItem();
        boolean result = adapter.changeDate(exam, date);

        if(!result)
        {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setHeaderText(null);
          alert.setTitle("Info");
          alert.setContentText("Last exam cannot be removed");
          alert.showAndWait();
        }
        else
        {
          dateField.setText(date.toString());
        }
      }
      else if (e.getSource() == examBox)
      {
        Exam temp = examBox.getSelectionModel().getSelectedItem();
        if (temp != null)
        {
          roomField.setText(String.valueOf(temp.getRoom()));
          courseField.setText(String.valueOf(temp.getCourse()));
          examinerField.setText(String.valueOf(temp.getExaminer()));
          dateField.setText(String.valueOf(temp.getDate()));
        }
      }
      else if (e.getSource() == datePicker)
      {
        dayField.setText(datePicker.getValue().getDayOfMonth()+"");
        monthField.setText(String.valueOf(datePicker.getValue().getMonthValue()));
        yearField.setText(String.valueOf(datePicker.getValue().getYear()));
      }
    }
  }


}
