package gleideveloper.com.br.genuinecoder.ui.book;

import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gleides on 09/02/2017.
 */
public class BookListController implements Initializable {
    ObservableList<Book> list = FXCollections.observableArrayList();

    public AnchorPane rootPaneListBook;
    public TableView<Book> tableViewBookList;
    public TableColumn<Book,String> idCol;
    public TableColumn<Book,String> titleCol;
    public TableColumn<Book,String> authorCol;
    public TableColumn<Book,String> publisherCol;
    public TableColumn<Book,Boolean> availabCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        loadData();
    }

    private void loadData() {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String query = "SELECT * FROM BOOK";
        ResultSet rs = handler.execQuery(query);
        try {
            while (rs.next()){
                String id = rs.getString("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                Boolean availability = rs.getBoolean("isAvail");

                list.addAll(new Book(id,title,author,publisher,availability));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(BookAddController.class.getName()).log(Level.SEVERE, null, e);
        }
        tableViewBookList.getItems().setAll(list);
    }

    private void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        availabCol.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("availability"));
    }
}
