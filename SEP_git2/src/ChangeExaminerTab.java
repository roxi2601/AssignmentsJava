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
  private TextField availabilityField;
  private TextField contactField;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label nameLabel;
  private Label availabilityLabel;
  private Label contactLabel;
  private Label datePickerLabel;

  private Teacher newExaminer;

  private MyActionListener listener;

  private TeacherAdapter adapter;

  /**
   * Constructor initializing the GUI components
   *
   * @param title   The title of the tab
   * @param adapter TeacherAdapter object used for retrieving and storing examiner information
   */
  public ChangeExaminerTab(String title, ExamScheduleAdapter adapter)
  {
    super(title);
    this.adapter = adapter;

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

    datePickerLabel = new Label("Date:");
    nameLabel = new Label("Name:");
    availabilityLabel = new Label("Availability:");
    contactLabel = new Label("Contact:");
    examinerBoxLabel = new Label("Examiner:");

    nameField = new TextField();
    nameField.setEditable(false);
    availabilityField = new TextField();
    availabilityField.setEditable(true);
    contactField = new TextField();
    contactField.setEditable(true);

    changeExaminerInputPane = new GridPane();
    changeExaminerInputPane.setVgap(5);
    changeExaminerInputPane.setHgap(5);
    changeExaminerInputPane.addRow(0, datePickerLabel, datePicker);
    changeExaminerInputPane.addRow(1, examinerBoxLabel, examinerBox);
    changeExaminerInputPane.addRow(2, nameLabel, nameField);
    changeExaminerInputPane.addRow(3, availabilityLabel, availabilityField);
    changeExaminerInputPane.addRow(4, contactLabel, contactField);

    addButton = new Button("Add");
    addButton.setOnAction(listener);

    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    addAndRemoveButtons = new HBox(20);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);

    examinerPane.getChildren().add(changeExaminerInputPane);
    examinerPane.getChildren().add(addAndRemoveButtons); //examiner data-end

    changeExaminerPane.getChildren().add(examPane);
    changeExaminerPane.getChildren().add(examinerPane);

    super.setContent(changeExaminerPane);
  }

  /**
   * Enables or disables editing of examinerField, courseField, roomField, dateField, availabilityField and contactField.
   *
   * @param bool if true then the fields will be editable, if false then they will not
   */
  public void changeEditableState(boolean bool)
  {
    examinerField.setEditable(bool);
    contactField.setEditable(bool);
    roomField.setEditable(bool);
    courseField.setEditable(bool);
    dateField.setEditable(bool);
    nameField.setEditable(bool);
  }

  /**
   * Updates the examinerBox ComboBox with information from the examiner file
   */
  public void updateExaminerBox()
  {
    int currentIndex = examinerBox.getSelectionModel().getSelectedIndex();

    examinerBox.getItems().clear();

    TeacherList examiners = adapter.getAllExaminers(); //we have to do getAllExaminers() in ExamScheduleAdapter
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
    public void handle(ActionEvent e)
    {
      if (e.getSource() == addButton)
      {
        Teacher temp = examinerBox.getSelectionModel().getSelectedItem();
        String name = nameField.getText();
        availability
        String contact = examinerBox.getSelectionModel().getSelectedItem();
        if (temp.equals(newExaminer))
        {
          adapter.addObject(examBox.getSelectionModel().getSelectedItem().getCourse(),
              examBox.getSelectionModel().getSelectedItem().getDate(), room);
          updateExaminerBox();
          contactField.setText("");
          availabilityField.setText("");
          Teacher examiner = new Teacher(name, contact);
        }
        else
        {
          adapter.changeExaminerData(
              examBox.getSelectionModel().getSelectedItem().getCourse(),
              examBox.getSelectionModel().getSelectedItem().getDate(), room);
          updateExaminerBox();
          contactField.setText("");
          availabilityField.setText("");
        }

      }
      else if (e.getSource() == removeButton)
      {
        Teacher temp = examinerBox.getSelectionModel().getSelectedItem();
        String name = nameField.getText();
        availability
        String contact = examinerBox.getSelectionModel().getSelectedItem();
        if (!(temp.equals(newExaminer)))
        {
          adapter.removeObject(examBox.getSelectionModel().getSelectedItem().getCourse(),
              examBox.getSelectionModel().getSelectedItem().getDate(), room);
          updateExaminerBox();
          contactField.setText("");
          availabilityField.setText("");
          Teacher examiner = new Teacher(name, contact);
        }
      } if (e.getSource() == examBox)
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

      if(temp != null)
      {
        nameField.setText(temp.getName());
        availabilityField.setText(String.valueOf(temp.getAvailability()));
        contactField.setText(temp.getContact());

      }
      else if(temp.equals(newExaminer))
      {
        contactField.setText("");
        availabilityField.setText("");
        nameField.setText(temp.getName());
        removeButton.isDisable(); //????????????????????????????????????????
      }
    }

    }
  }
}
