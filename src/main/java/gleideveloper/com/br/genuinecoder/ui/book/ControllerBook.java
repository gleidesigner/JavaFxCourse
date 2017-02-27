package gleideveloper.com.br.genuinecoder.ui.book;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gleides on 07/02/2017.
 */
public class ControllerBook implements Initializable{

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton cancel;

    DatabaseHandler databaseHandler;
    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHandler = new DatabaseHandler();
        checkData();
    }

    private void checkData() {
        String query = "SELECT title FROM BOOK";
        ResultSet rs = databaseHandler.execQuery(query);
        try {
            while (rs.next()){
                String title = rs.getString("title");
                System.out.println(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void addBook(ActionEvent actionEvent) {
        String bookID = id.getText();
        String bookTitle = title.getText();
        String bookAuthor = author.getText();
        String bookPublisher = publisher.getText();

        if(bookID.isEmpty() || bookAuthor.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter the fields");
            alert.showAndWait();
            return;
        }

        String query = "INSERT INTO BOOK VALUES ("
                + "'" + bookID +"',"
                + "'" + bookTitle +"',"
                + "'" + bookAuthor +"',"
                + "'" + bookPublisher +"',"
                + "" + true + ""
                + ")";
        System.out.println(query);

        if(databaseHandler.execAction(query)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("SUCCESS");
            alert.showAndWait();
        }/*else{//ERROR
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("FAILED");
            alert.showAndWait();
        }*/
    }

    public void cancelBook(ActionEvent actionEvent) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}
