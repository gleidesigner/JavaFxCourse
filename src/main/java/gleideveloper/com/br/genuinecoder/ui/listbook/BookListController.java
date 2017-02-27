package gleideveloper.com.br.genuinecoder.ui.listbook;

import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import gleideveloper.com.br.genuinecoder.ui.book.ControllerBook;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
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
    public TableView<Book> tableViewListBook;
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
        DatabaseHandler handler = new DatabaseHandler();
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
            Logger.getLogger(ControllerBook.class.getName()).log(Level.SEVERE, null, e);
        }
        tableViewListBook.getItems().setAll(list);
    }

    private void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        availabCol.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("availability"));
    }

    public static class Book{
        private final SimpleStringProperty id;
        private final SimpleStringProperty title;
        private final SimpleStringProperty author;
        private final SimpleStringProperty publisher;
        private final SimpleBooleanProperty availability;

        public Book(String id, String title, String author, String publisher, Boolean availability) {
            this.id = new SimpleStringProperty(id);
            this.title = new SimpleStringProperty(title);
            this.author = new SimpleStringProperty(author);
            this.publisher = new SimpleStringProperty(publisher);
            this.availability = new SimpleBooleanProperty(availability);
        }

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public String getTitle() {
            return title.get();
        }

        public SimpleStringProperty titleProperty() {
            return title;
        }

        public String getAuthor() {
            return author.get();
        }

        public SimpleStringProperty authorProperty() {
            return author;
        }

        public String getPublisher() {
            return publisher.get();
        }

        public SimpleStringProperty publisherProperty() {
            return publisher;
        }

        public boolean isAvailability() {
            return availability.get();
        }

        public SimpleBooleanProperty availabilityProperty() {
            return availability;
        }
    }
}
