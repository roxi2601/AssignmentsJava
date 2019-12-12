import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//import java.util.ArrayList;
//import java.util.Locale;
/**
 * A user interface that allows for displaying and modifying information about exams.
 * @author Julia Tankiewicz
 * @version 1.0
 */
public class ExamScheduleFileAdapterGUI extends Application
{
  private ExamScheduleAdapter adapter;

  private VBox mainPane;

  private TabPane tabPane;
  private ExamTab examsTab;
  private MenageCourseDataTab changeCourseTab;
  private ChangeExaminerTab changeExaminerTab;
  private ChangeRoomTab changeRoomTab;
  private ChangeDateTab changeDateTab;
  private AddNewExamTab addNewTab;

  private MenuBar menuBar;

  private Menu fileMenu;
  private Menu editMenu;
  private Menu aboutMenu;

  private MenuItem exitMenuItem;
  private MenuItem newMenuItem;
  private MenuItem saveMenuItem;
  private MenuItem updateWebsiteMenuItem;
  private MenuItem aboutMenuItem;

  private CheckMenuItem editMenuItem;

  private MyActionListener listener;
  private MyTabListener tabListener;

  /**
   * @param window The Stage object that will be displayed
   */
  public void start(Stage window)
  {
    window.setTitle("Exam Schedule");

    adapter = new ExamScheduleAdapter();

    listener = new MyActionListener();
    tabListener = new MyTabListener();

    tabPane = new TabPane();
    tabPane.getSelectionModel().selectedItemProperty().addListener(tabListener);

    examsTab = new ExamTab("Exams");
    changeCourseTab = new MenageCourseDataTab("Course Data");
    changeExaminerTab =new  ChangeExaminerTab("Change Examiner");
    changeRoomTab =new  ChangeRoomTab("Change Room");
    changeDateTab =new  ChangeDateTab("Change Date");
    addNewTab =new AddNewExamTab("Add new");

    tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    tabPane.getTabs().addAll(examsTab,changeCourseTab,changeExaminerTab,changeRoomTab,changeDateTab,addNewTab);

    exitMenuItem = new MenuItem("Exit");
    exitMenuItem.setOnAction(listener);

    aboutMenuItem = new MenuItem("About");
    aboutMenuItem.setOnAction(listener);

    fileMenu = new Menu("File");
    editMenu = new Menu("Edit");
    aboutMenu = new Menu("About");

    fileMenu.getItems().add(exitMenuItem);

    aboutMenu.getItems().add(aboutMenuItem);

    menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu,editMenu,aboutMenu);

    mainPane  = new VBox();
    mainPane.getChildren().addAll(menuBar,tabPane);

    Scene scene = new Scene(mainPane);

    window.setScene(scene);
    window.show();
  }
  /*
   * Inner action listener class
   * @author Julia Tankiewicz
   * @version 1.0
   */

  private class MyActionListener implements EventHandler<ActionEvent>
  {
    public void handle(ActionEvent e)
    {
      if(e.getSource() ==exitMenuItem)
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to exit the program?",ButtonType.YES,ButtonType.NO);
        alert.setTitle("Exit");
        alert.setHeaderText(null);//header text??

        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES)
        {
          System.exit(0);
        }
      }
      else if (e.getSource() == aboutMenuItem)
      {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("This is system to schedule exa period");
        alert.showAndWait();
      }

    }
  }
  /*
   * Inner change listener class
   * @author Julia Tankiewicz
   * @version 1.0
   */
  private class MyTabListener implements ChangeListener<Tab>
  {
    public void changed(ObservableValue<? extends Tab> tab,Tab oldTab,Tab newTab)
    {
      if(newTab==examsTab)
      {
        examsTab.updateCourseBox();
        examsTab.updateExaminerBox();
        examsTab.updateExamsTable();
        examsTab.updateRoomBox();
      }
      else if(newTab==addNewTab)
      {
        addNewTab.updateCourseBox();
        addNewTab.updateExaminerBox();
        addNewTab.updateRoomBox();
      }
      else if(newTab==changeDateTab)
      {
        changeDateTab.updateExamBox();
      }
      else if(newTab==changeCourseTab)
      {
        changeCourseTab.updateCourseBox();
      }
      else if(newTab==changeExaminerTab)
      {
        changeExaminerTab.updateExaminerBox();
      }
      else if(newTab==changeRoomTab)
      {
        changeRoomTab.updateRoomBox();
      }
    }
  }

}
