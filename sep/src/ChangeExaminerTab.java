import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
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
  private CheckBox changeExamBox;

  private DatePicker datePicker;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField nameField;

  private TextField contactField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label nameLabel;
  private Label unavailabilityLabel;
  private Label contactLabel;

  private ListView<MyDate> unavailabilityList;

  private Teacher newExaminer;

  private MyActionListener listener;
  private MyListListener listenerList;

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

    newExaminer = new Teacher("New","contact");

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

    unavailabilityList = new ListView<MyDate>();
    unavailabilityList.setPrefHeight(100);
    //unavailabilityList.getSelectionModel().selectedItemProperty().addListener(listenerList);

    contactField = new TextField();
    contactField.setEditable(true);

    changeExaminerInputPane = new GridPane();
    changeExaminerInputPane.setVgap(5);
    changeExaminerInputPane.setHgap(5);

    changeExaminerInputPane.addRow(0, examinerBoxLabel, examinerBox);
    changeExaminerInputPane.addRow(1, nameLabel, nameField);
    changeExaminerInputPane.addRow(2,  datePicker);
    changeExaminerInputPane.addRow(3, unavailabilityLabel, unavailabilityList);
    changeExaminerInputPane.addRow(4, contactLabel, contactField);

    addButton = new Button("Add/Change");
    addButton.setOnAction(listener);

    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    changeExamBox = new CheckBox("Change in the exam");
    changeExamBox.setOnAction(listener);

    addAndRemoveButtons = new HBox(20);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(changeExamBox);
    addAndRemoveButtons.getChildren().add(removeButton);


    examinerPane.getChildren().add(changeExaminerInputPane);
    examinerPane.getChildren().add(addAndRemoveButtons);
    //examiner data-end

    changeExaminerPane.getChildren().add(examPane);
    changeExaminerPane.getChildren().add(examinerPane);

    super.setContent(changeExaminerPane);
  }

  public void updateListView()
  {

  }
  public void updateExamBox()
  {
    int currentIndex = examBox.getSelectionModel().getSelectedIndex();

    examBox.getItems().clear();
    ExamSchedule exams = examScheduleAdapter.getAllExams();

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
   * @author Roksana Dziadowicz and Julia Tankiewicz
   * @version 1.0
   */
  private class MyActionListener implements EventHandler<ActionEvent>
  {
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
        String contact = contactField.getText();
        Teacher examiner = new Teacher(name, contact);
        ArrayList<MyDate> unavailable = (ArrayList<MyDate>)unavailabilityList.getItems();
        examiner.setUnavailability(unavailable);
        if (temp.equals(newExaminer))
        {
          adapter.addTeacher(examiner);
        }
        else
        {
          adapter.changeTeacher(temp,examiner);
        }
        updateExaminerBox();
        if(changeExamBox.isSelected())
        {
          examScheduleAdapter.changeExaminer(examBox.getSelectionModel().getSelectedItem(), examiner);
          examinerField.setText(examiner.toString());
        }
      }
      else if (e.getSource() == removeButton)
      {
        Teacher temp = examinerBox.getSelectionModel().getSelectedItem();
        if(temp!=null && !(temp.equals(newExaminer)))
        {
          adapter.removeTeacher(temp);
        }
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

        if (temp != null && !(temp.equals(newExaminer)))
        {
          nameField.setEditable(false);
          nameField.setText(temp.getName());
          contactField.setText(temp.getContact());

          int currentIndex = unavailabilityList.getSelectionModel().getSelectedIndex();

          unavailabilityList.getItems().clear();

          for (int i = 0; i < temp.getUnavailability().size(); i++)
          {
            unavailabilityList.getItems().add(temp.getUnavailability().get(i));
          }

          if (currentIndex == -1 && unavailabilityList.getItems().size() > 0)
          {
            unavailabilityList.getSelectionModel().select(0);
          }
          else
          {
            unavailabilityList.getSelectionModel().select(currentIndex);
          }
        }
        else if (temp!=null &&temp.equals(newExaminer))
        {
          contactField.setText("");
          unavailabilityList.getItems().clear();
          nameField.setText("");
          nameField.setEditable(true);
        }
      }
      else if(e.getSource()==datePicker)
      {
        int day = datePicker.getValue().getDayOfMonth();
        int month = datePicker.getValue().getMonthValue();
        int year = datePicker.getValue().getYear();

        unavailabilityList.getItems().add(new MyDate(day, month, year));

      }
    }
    }

  private class MyListListener implements ChangeListener<MyDate>
  {
    public void changed(ObservableValue<? extends MyDate> date, MyDate oldDate, MyDate newDate)
    {
      MyDate temp = unavailabilityList.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
       //unavailabilityList
      }
    }
  }
}
