/* Imports */
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RopeDropTracker extends Application {

    /* These are the attributes of the rope drop tracker. */
    private TextField txtTemp = new TextField();
    private TextField txtHumidity = new TextField();
    private TextField txtHarnessCount = new TextField();
    private TextField txtHarnessID = new TextField();
    private TextField txtCarabinerCount = new TextField();
    private TextField txtSRCount = new TextField();
    private TextField txtQRCount = new TextField();
    private ComboBox<String> cbIndyName = new ComboBox<>();
    private String[] indyDoubles = {"Aaron Zoldan" , "Ryan McVeigh", "Kevin Brassard", "Chris Barra", "Mitchell Warren", "Andrew Trask", "Justin Beard", "Niko Bugoki", "Trayvor", "Cory Stark", "Sean Lyle", "Kevin Campbell", "Emmanuel Rodriguez Sanfeliz",};
    private TextField txtIndyWeight = new TextField();
    private TextField txtIndyDrop = new TextField();
    private ComboBox<String> cbTech = new ComboBox<>();
    private String[] techNames = { "Keran Schexnayder-Bohne", "Bruce Ruiz", "Tom Judd", "Alix Haugen", "Cheyenne Zuck", "Stevie Schlenker", "Tom Biemann", "Kelley Letourneau", "Jake Hines", "Jean-Marc Biron", "Todd Tedson"};

    private Label lblTemp = new Label("Temperature: ");
    private Label lblHumidity = new Label ("Humidity: ");
    private Label lblHarnessCount= new Label("Harness Count: ");
    private Label lblHarnessID = new Label("Harness ID: ");
    private Label lblCarabinerCount = new Label("Carabiner Count: ");
    private Label lblSRCount = new Label ("Shuttle Rope Count: ");
    private Label lblQRCount = new Label ("Quick Release Count: ");
    private Label lblIndyName = new Label ("Indy: ");
    private Label lblIndyWeight = new Label ("Indy Weight: ");
    private Label lblIndyDropDistance = new Label ("Indy Drop Distance: ");
    private Label lblTechName = new Label ("Tech: ");

    private Button btnClear = new Button("Clear Rope Drop Fields");
    private Button btnSave = new Button("Save Rope Drop Entry");
    private Button btnView = new Button("View Rope Drop Entries");
    private TextArea txtResults = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rope Drop Tracker"); /* Title set. */

        /* This creates the pane and adds all my attributes to it. */
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(txtHarnessID, 1, 0);
        pane.add(txtHarnessCount, 1, 1);
        pane.add(txtCarabinerCount, 1, 2);
        pane.add(txtSRCount, 1, 3);
        pane.add(txtQRCount, 1, 4);
        pane.add(lblHarnessID, 0, 0);
        pane.add(lblHarnessCount, 0, 1);
        pane.add(lblCarabinerCount, 0, 2);
        pane.add(lblSRCount, 0, 3);
        pane.add(lblQRCount, 0, 4);
        pane.add(lblIndyName, 0, 5);
        pane.add(cbIndyName, 1, 5, 2, 1);
        pane.add(txtIndyWeight, 1, 6);
        pane.add(lblIndyWeight, 0, 6);
        pane.add(txtIndyDrop, 1, 7);
        pane.add(lblIndyDropDistance, 0, 7);
        pane.add(cbTech, 1, 8);
        pane.add(lblTechName, 0, 8);
        pane.add(txtTemp, 1, 9);
        pane.add(lblTemp, 0, 9);
        pane.add(txtHumidity, 1, 10);
        pane.add(lblHumidity, 0, 10);
        pane.add(txtResults,0,13,2,1);

        /* This sets the values for the grades combo box. */
        ObservableList<String>technicians = FXCollections.observableArrayList(techNames);
        cbTech.getItems().addAll(technicians);
        ObservableList<String>indies = FXCollections.observableArrayList(indyDoubles);
        cbIndyName.getItems().addAll(indies);

        /* This creates a container for my three buttons, positions it, and adds it to the pane. */
        HBox actionBtn = new HBox();
        actionBtn.setPadding(new Insets(15, 0, 15, 30));
        actionBtn.setSpacing(10);
        actionBtn.getChildren().add(btnClear);
        actionBtn.getChildren().add(btnSave);
        actionBtn.getChildren().add(btnView);
        pane.add(actionBtn, 0, 12, 2, 1);
        GridPane.setHalignment(actionBtn, HPos.CENTER);

        /* This sets the actions for the buttons. */
        btnClear.setOnAction(e -> clearFormFields());
        btnSave.setOnAction(e -> saveRDEntry());
        btnView.setOnAction(e -> viewGrades());

        /* This creates the scene, adds the pane to the scene, the scene to the stage, and then shows the stage. */
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    } /* End overridden start method. */

    private void clearFormFields(){
        txtHarnessID.setText("");
        txtHarnessCount.setText("");
        txtIndyWeight.setText("");
        txtIndyDrop.setText("");
        txtSRCount.setText("");
        txtQRCount.setText("");
        txtCarabinerCount.setText("");
        txtHumidity.setText("");
        txtTemp.setText("");
        cbIndyName.setValue(null);
        cbTech.setValue(null);
        txtResults.setText("");
    }

    /* This writes the field entries to a file called "grades.csv". */
    private void saveRDEntry(){
        ArrayList<Entry> entries = new ArrayList<Entry>();

        Entry entry = new Entry();
        entry.setHarnessID(txtHarnessID.getText());
        entry.setHarnessCount(txtHarnessCount.getText());
        entry.setCarabinerCount(txtCarabinerCount.getText());
        entry.setQRCount(txtQRCount.getText());
        entry.setSRCount(txtSRCount.getText());
        entry.setIndyName(cbIndyName.getValue());
        entry.setIndyWeight(txtIndyWeight.getText());
        entry.setDropDistance(txtIndyDrop.getText());
        entry.setTechName(cbTech.getValue());
        entry.setTemp(txtTemp.getText());
        entry.setHumidity(txtHumidity.getText());

        entries.add(entry);
        try {
            EntryIO.insert(entries);
        } catch (IOException e) {
            System.out.println("\n Exception " + e.getMessage());
        }
    }
    /* This method presents all of the saved grade entries in the file in the results area. */
    private void viewGrades(){
        try {
            ArrayList<Entry> entries = EntryIO.findAll();
            String viewedEntries = "";
            for (Entry entry: entries){
                viewedEntries += entry.toString() + "\n";
            } 
            txtResults.setText(viewedEntries);
        }catch (IOException e) {
            txtResults.setText("\n Exception " + e.getMessage());
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
