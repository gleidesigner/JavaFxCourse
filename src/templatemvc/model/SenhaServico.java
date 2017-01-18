package templatemvc.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by gleidesilva on 17/01/17.
 */
public class SenhaServico {
    private StringProperty site = new SimpleStringProperty();
    private StringProperty login = new SimpleStringProperty();

    public SenhaServico(String site, String login) {
        this.site.set(site);
        this.login.set(login);
    }

    public String getSite() {
        return site.get();
    }

    public StringProperty siteProperty() {
        return site;
    }

    public void setSite(String site) {
        this.site.set(site);
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }
}
