package gleideveloper.com.br.genuinecoder.ui.member;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Gleides on 01/03/2017.
 */
public class Member {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty mobile;
    private SimpleStringProperty email;

    public Member(String id, String name, String mobile, String email) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.mobile = new SimpleStringProperty(mobile);
        this.email = new SimpleStringProperty(email);
    }
    public Member(){
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getMobile() {
        return mobile.get();
    }

    public SimpleStringProperty mobileProperty() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = new SimpleStringProperty(mobile);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }
}
