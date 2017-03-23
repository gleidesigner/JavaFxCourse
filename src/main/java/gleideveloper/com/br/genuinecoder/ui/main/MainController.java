package gleideveloper.com.br.genuinecoder.ui.main;

import com.jfoenix.effects.JFXDepthManager;
import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import gleideveloper.com.br.genuinecoder.ui.util.MessageAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gleides on 04/03/2017.
 */
public class MainController extends MessageAlert implements Initializable {
    @FXML
    private  Text bookName;
    @FXML
    private  Text bookAuthor;
    @FXML
    private  Text bookStatus;
    @FXML
    private TextField bookIDInput;
    @FXML
    private HBox book_info;
    @FXML
    private HBox member_info;

    private DatabaseHandler databaseHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXDepthManager.setDepth(book_info, 1);
        JFXDepthManager.setDepth(member_info, 1);
        databaseHandler = DatabaseHandler.getInstance();
    }

    public void loadAddMember(ActionEvent actionEvent) {
        loadWindow("/fxml/genuinecoder/member_add_controller.fxml","Add New Member");
    }

    public void loadAddBook(ActionEvent actionEvent) {
        loadWindow("/fxml/genuinecoder/book_add_controller.fxml","Add New Book");
    }

    public void loadAddMemberTable(ActionEvent actionEvent) {
        loadWindow("/fxml/genuinecoder/member_list_controller.fxml","Add Member List");
    }

    public void loadAddBookTable(ActionEvent actionEvent) {
        loadWindow("/fxml/genuinecoder/book_list_controller.fxml","Add Book List");
    }

    public void settings(ActionEvent actionEvent) {
        //loadWindow("/fxml/genuinecoder/member_add_controller.fxml","Add New Member");
    }

    public void loadWindow(String path, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(path));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadBookInfo(ActionEvent actionEvent) {
        String id = bookIDInput.getText();
        String  sql =  "SELECT * FROM BOOK WHERE id = '" + id +"'";
        ResultSet rs = databaseHandler.execQuery(sql);

        Boolean flag = false;
        try {
            while (rs.next()) {
                String title = rs.getString("title");
                String autor = rs.getString("author");
                Boolean status = rs.getBoolean("isAvail");

                bookName.setText(title);
                bookAuthor.setText(autor);
                String isAvailable = (status ? "Available" : "Not Available");
                bookStatus.setText(isAvailable);
                flag = true;
            }

            if(!flag){
                bookName.setText("No Such Book Available");
            }
        } catch(SQLException ex){
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);

        }
    }
}
