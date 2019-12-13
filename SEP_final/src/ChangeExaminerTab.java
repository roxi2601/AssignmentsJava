import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * A GUI tab containing components for changing a exam's examiner.
 * @author Roksana Dziadowicz and Julia Tankiewicz
 * @version 1.0
 */
public class ChangeExaminerTab extends Tab
{
  private HBox changeExaminerPane; //all

  private HBox addAndRemoveButtons;

  private VBox examPane; // left
  private VBox examinerPane; //right

  private ComboBox<Exam> examBox;
  private ComboBox<Teacher> examinerBox;

  private Label examBoxLabel;
  private Label examinerBoxLabel;

  private GridPane changeExaminerInputPane; //right
  private GridPane examDataPane; //left

  private Button addButton;
  private Button removeButton;

  private DatePicker datePicker;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField nameField;
  private TextField unavailabilityField;
  private TextField contactField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label nameLabel;
  private Label unavailabilityLabel;
  private Label contactLabel;

  private Teacher newExaminer;

  private MyActionListener listener;

  private TeacherAdapter adapter;
  private ExamScheduleAdapter examScheduleAdapter;

  /**
   * Constructor initializing the GUI components
   * @param title   The title of the tab
   */
  public ChangeExaminerTab(String title)
  {
    super(title);
    this.adapter = new TeacherAdapter();
    this.examScheduleAdapter = new ExamScheduleAdapter();

    newExaminer = new Teacher("New","");

    listener = new MyActionListener();

    changeExaminerPane = new HBox(20);

    //exam data-start
    examPane = new VBox(20);
    examPane.setPrefWidth(200);

    examBox = new ComboBox<Exam>();
    examBox.setOnAction(listener);

    roomLabel = new Label("Room:");
    courseLabel = new Label("Course");
    examinerLabel = new Label("Examiner:");
    dateLabel = new Label("Date");
    examBoxLabel = new Label("Exam:");

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
    examDataPane.addRow(0, examBoxLabel, examBox);
    examDataPane.addRow(1, examinerLabel, examinerField);
    examDataPane.addRow(2, courseLabel, courseField);
    examDataPane.addRow(3, roomLabel, roomField);
    examDataPane.addRow(4, dateLabel, dateField);

    examPane.getChildren().add(examDataPane);
    //exam data-end

    //examiner data- start
    examinerPane = new VBox(20);
    examinerPane.setPrefWidth(200);

    examinerBox = new ComboBox<Teacher>();
    examinerBox.setOnAction(listener);

    datePicker = new DatePicker();


    nameLabel = new Label("Name:");
    unavailabilityLabel = new Label("Unavailability:");
    contactLabel = new Label("Contact:");
    examinerBoxLabel = new Label("Examiner:");

    nameField = new TextField();
    nameField.setEditable(false);
    unavailabilityField = new TextField();
    unavailabilityField.setEditable(true);
    contactField = new TextField();
    contactField.setEditable(true);

    changeExaminerInputPane = new GridPane();
    changeExaminerInputPane.setVgap(5);
    changeExaminerInputPane.setHgap(5);

    changeExaminerInputPane.addRow(0, examinerBoxLabel, examinerBox);
    changeExaminerInputPane.addRow(1, nameLabel, nameField);
    changeExaminerInputPane.addRow(2,  datePicker);
    changeExaminerInputPane.addRow(3, unavailabilityLabel, unavailabilityField);
    changeExaminerInputPane.addRow(4, contactLabel, contactField);

    addButton = new Button("Add");
    addButton.setOnAction(listener);

    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    addAndRemoveButtons = new HBox(20);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);

    examinerPane.getChildren().add(changeExaminerInputPane);
    examinerPane.getChildren().add(addAndRemoveButtons);
    //examiner data-end

    changeExaminerPane.getChildren().add(examPane);
    changeExaminerPane.getChildren().add(examinerPane);

    super.setContent(changeExaminerPane);
  }

  /**
   * Updates the examinerBox ComboBox with information from the examiner file
   */
  public void updateExaminerBox()
  {
    int currentIndex = examinerBox.getSelectionModel().getSelectedIndex();
    examinerBox.getItems().clear();
    examinerBox.getItems().add(newExaminer);
    TeacherList examiners = adapter.getAllTeachers();
    for (int i = 0; i < examiners.size(); i++)
    {
      examinerBox.getItems().add(examiners.getAllTeachers().get(i));
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
   * @author Roksana Dziadowicz and Julia Tankiewicz
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
    ArrayList<MyDate> unavailability = new ArrayList<MyDate>();
    public String getUnavailability()
    {
      String str = "";
      for(int i= 0;i<unavailability.size();i++)
      {
        str+=unavailability.get(i)+", ";
      }
      return str;
    }
    public void handle(ActionEvent e)
    {
      if (e.getSource() == addButton)
      {
        Teacher temp = examinerBox.getSelectionModel().getSelectedItem();
        String name="?";
        if(nameField.getText().isEmpty() || nameField.getText().contains("[0-9]+")==true)
        {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setHeaderText(null);
          alert.setTitle("Warning");
          alert.setContentText("Name cannot contain numbers or be empty, please type only letters :)");
          alert.showAndWait();
        }
        else
        {
          name = nameField.getText();
        }

        String contact = examinerBox.getSelectionModel().getSelectedItem().getContact();
        Teacher examiner = new Teacher(name, contact);
        if (temp.equals(newExaminer))
        {
          examiner.setUnavailability(unavailability);
          adapter.addTeacher(examiner);
        }
        else
        {
          adapter.changeTeacher(temp,examiner);
        }
        examScheduleAdapter.changeExaminer(examBox.getSelectionModel().getSelectedItem(),examiner);

      }
      else if (e.getSource() == removeButton)
      {
        Teacher temp = examinerBox.getSelectionModel().getSelectedItem();
        adapter.removeTeacher(temp);
      }
      if (e.getSource() == examBox)
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
    else if (e.getSource() == examinerBox)
    {
      Teacher temp = examinerBox.getSelectionModel().getSelectedItem();

      if(!temp.equals(newExaminer))
      {
        nameField.setText(temp.getName());
        unavailabilityField.setText(String.valueOf(temp.getUnavailability()));
        contactField.setText(temp.getContact());
      }
      else if(temp.equals(newExaminer))
      {
        contactField.setText("");
        unavailabilityField.setText("");
        nameField.setText("");
        nameField.setEditable(true);
        removeButton.setDisable(true);
      }
      else if(e.getSource()==datePicker)
      {
        int day = datePicker.getValue().getDayOfMonth();
        int month = datePicker.getValue().getMonthValue();
        int year = datePicker.getValue().getYear();
        unavailability.add(new MyDate(day, month, year));
        unavailabilityField.setText(""+getUnavailability());
      }
    }
    }
  }
}
