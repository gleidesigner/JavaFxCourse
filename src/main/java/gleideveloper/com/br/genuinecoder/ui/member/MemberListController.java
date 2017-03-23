package gleideveloper.com.br.genuinecoder.ui.member;
/**
 * Created by Gleides on 02/03/2017.
 */

import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import gleideveloper.com.br.genuinecoder.ui.book.BookAddController;
import gleideveloper.com.br.genuinecoder.ui.util.MessageAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberListController extends MessageAlert implements Initializable {

    ObservableList<Member> list = FXCollections.observableArrayList();
    public TableView<Member> tableViewMemberList;
    public TableColumn<Member, String> idCol;
    public TableColumn<Member, String> nameCol;
    public TableColumn<Member, String> mobileCol;
    public TableColumn<Member, String> emailCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        loadData();
    }

    private void loadData() {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String query = "SELECT * FROM MEMBER";
        ResultSet rs = handler.execQuery(query);
        try {
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");

                list.addAll(new Member(id,name,mobile,email));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(BookAddController.class.getName()).log(Level.SEVERE, null, e);
        }
        tableViewMemberList.getItems().setAll(list);
    }

    private void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<Member, String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
        mobileCol.setCellValueFactory(new PropertyValueFactory<Member, String>("mobile"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Member, String>("email"));
    }
}
