package gleideveloper.com.br.genuinecoder.ui.addmember;

/**
 * Created by Gleides on 01/03/2017.
 */
public class Member {
    private String id;
    private String name;
    private String mobile;
    private String email;

    public String getId() {
        return id;
    }

    public Member setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Member setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Member setEmail(String email) {
        this.email = email;
        return this;
    }
}
