import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;

/**
 * A GUI tab containing components for changing a exam's room.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class ChangeRoomTab extends Tab
{
  private HBox changeRoomPane; //all

  private HBox addAndRemoveButtons;

  private VBox examPane; // left
  private VBox roomPane; //right

  private ComboBox<Exam> examBox;
  private ComboBox<Room> roomBox;

  private Label examBoxLabel;

  private GridPane changeRoomInputPane; //right
  private GridPane examDataPane; //left

  private Button addButton;
  private Button removeButton;

  private TextField courseField;
  private TextField examinerField;
  private TextField roomField;
  private TextField dateField;
  private TextField seatsField;
  private TextField roomNumberField;

  private CheckBox projectorBox;

  private Label courseLabel;
  private Label examinerLabel;
  private Label roomLabel;
  private Label dateLabel;
  private Label seatsLabel;
  private Label roomNumberLabel;

  private Room newRoom;

  private MyActionListener listener;

  private RoomAdapter adapter;

  /**
   * Constructor initializing the GUI components
   * @param title The title of the tab
   * @param adapter RoomAdapter object used for retrieving and storing room information
   */
  public ChangeRoomTab(String title, RoomAdapter adapter)
  {
    super(title);

    this.adapter = adapter;

    listener = new MyActionListener();

    changeRoomPane = new HBox(20);

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
      examDataPane.addRow(1, roomLabel, roomField);
      examDataPane.addRow(2, courseLabel, courseField);
      examDataPane.addRow(3, examinerLabel, examinerField);
      examDataPane.addRow(4, dateLabel, dateField);
       examPane.getChildren().add(examDataPane);
         //exam data-end

    //room data- start
    roomPane = new VBox(20);
    roomPane.setPrefWidth(200);

    roomBox = new ComboBox<Room>();
    roomBox.setOnAction(listener);

    projectorBox = new CheckBox("Projector ");

    seatsLabel = new Label("Number of seats:");
    roomNumberLabel = new Label("Room number:");


    seatsField = new TextField();
    seatsField.setEditable(true);
    roomNumberField = new TextField();
    roomNumberField.setEditable(false);

    changeRoomInputPane = new GridPane();
    changeRoomInputPane.setVgap(5);
    changeRoomInputPane.setHgap(5);
    changeRoomInputPane.addRow(0, seatsLabel, seatsField);
    changeRoomInputPane.addRow(1, roomNumberLabel, roomNumberField);

    addButton = new Button("Add");
    addButton.setOnAction(listener);

    removeButton = new Button("Remove");
    removeButton.setOnAction(listener);

    addAndRemoveButtons = new HBox(20);
    addAndRemoveButtons.getChildren().add(addButton);
    addAndRemoveButtons.getChildren().add(removeButton);

    roomPane.getChildren().add(roomBox);
    roomPane.getChildren().add(projectorBox);
    roomPane.getChildren().add(changeRoomInputPane);
    roomPane.getChildren().add(addAndRemoveButtons); //room data-end

    changeRoomPane.getChildren().add(examPane);
    changeRoomPane.getChildren().add(roomPane);

    super.setContent(changeRoomPane);

  }
    /**
     * Enables or disables editing of roomField, courseField, examinerField, dateField and roomNumberField.
     * @param bool if true then the fields will be editable, if false then they will not
     */
    public void changeEditableState (boolean bool)
    {
      roomField.setEditable(bool);
      courseField.setEditable(bool);
      examinerField.setEditable(bool);
      dateField.setEditable(bool);
      roomNumberField.setEditable(bool);
    }
  /**
   * Updates the roomBox ComboBox with information from the room file
   */
  public void updateRoomBox()
  {
    int currentIndex = roomBox.getSelectionModel().getSelectedIndex();

    roomBox.getItems().clear();

    RoomList rooms = adapter.getAllRooms();
    for (int i = 0; i < rooms.size(); i++)
    {
      roomBox.getItems().add(rooms.getAllRooms().get(i));
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
        Room temp = roomBox.getSelectionModel().getSelectedItem();
        int seats = Integer.parseInt(seatsField.getText());
        String roomNumber = roomNumberField.getText();
        if(temp.equals(newRoom))
        {
          adapter.addObject(examBox.getSelectionModel().getSelectedItem().getCourse(), examBox.getSelectionModel().getSelectedItem().getDate(), room);
          updateRoomBox();
          seatsField.setText("");
          Room room=new Room(roomNumber,seats);
        if(projectorBox.isSelected())
        {
          room.setProjector(true);
        }
        else
        {
          room.setProjector(false);
        }
        }
        else
        {
          adapter.changeRoomData(examBox.getSelectionModel().getSelectedItem().getCourse(), examBox.getSelectionModel().getSelectedItem().getDate(), room);
          updateRoomBox();
          seatsField.setText("");
        }

      }
        else if(e.getSource() == removeButton)
      {
        Room temp = roomBox.getSelectionModel().getSelectedItem();
        if(!(temp.equals(newRoom)))
        {
          int seats = Integer.parseInt(seatsField.getText());
          String roomNumber = roomNumberField.getText();
          Room room=new Room(roomNumber,seats);
          if(projectorBox.isSelected())
          {
            room.setProjector(true);
          }
          else
          {
            room.setProjector(false);
          }
          adapter.removeRoom(examBox.getSelectionModel().getSelectedItem().getCourse(), examBox.getSelectionModel().getSelectedItem().getDate(), room);
          updateRoomBox();
          seatsField.setText("");
        }
      }
        if (e.getSource() == examBox)
      {
        Exam temp = examBox.getSelectionModel().getSelectedItem();
        if(temp != null)
        {
          roomField.setText(String.valueOf(temp.getRoom()));
          courseField.setText(String.valueOf(temp.getCourse()));
          examinerField.setText(String.valueOf(temp.getExaminer()));
          dateField.setText(String.valueOf(temp.getDate()));
        }
      }
      else if (e.getSource() == roomBox)
      {
        Room temp = roomBox.getSelectionModel().getSelectedItem();

        if(temp != null)
        {
          if(temp.isProjector())
          {
            projectorBox.setSelected(true);
          }
          seatsField.setText(String.valueOf(temp.getSeatsCapacity()));
          roomNumberField.setText(temp.getNumber());

        }
        else if(temp.equals(newRoom))
        {
          seatsField.setText("");
          roomNumberField.setText(temp.getNumber());
          removeButton.isDisable(); //????????????????????????????????????????
        }

      }
    }
  }
}
