package gleideveloper.com.br.genuinecoder.ui.book;

import com.jfoenix.controls.JFXTextField;
import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import gleideveloper.com.br.genuinecoder.ui.util.MessageAlert;
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
public class BookAddController extends MessageAlert implements Initializable{

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    @FXML
    private AnchorPane rootPaneBook;
    DatabaseHandler databaseHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHandler = DatabaseHandler.getInstance();
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
            Logger.getLogger(BookAddController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void addBook(ActionEvent actionEvent) {
        String bookID = id.getText();
        String bookTitle = title.getText();
        String bookAuthor = author.getText();
        String bookPublisher = publisher.getText();

        if(bookID.isEmpty() || bookAuthor.isEmpty()){
            //Metodo Alert herdado da classe abastrata MessageAlert
            getMsgAlert(Alert.AlertType.ERROR, "Please Enter the fields");
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
            //Metodo Alert herdado da classe abastrata MessageAlert
            getMsgAlert(Alert.AlertType.INFORMATION, "Save whit SUCCESS");
        }
    }

    public void cancelBook(ActionEvent actionEvent) {
        Stage stage = (Stage) rootPaneBook.getScene().getWindow();
        stage.close();
    }
}
