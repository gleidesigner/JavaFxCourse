package gleideveloper.com.br.genuinecoder.ui.book;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Gleides on 02/03/2017.
 */
public class Book{
    private SimpleStringProperty id;
    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleStringProperty publisher;
    private SimpleBooleanProperty availability;

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