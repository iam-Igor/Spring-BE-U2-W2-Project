package ygorgarofalo.SpringU2W2Project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {


    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String surname;

    private String email;

    private String username;

    @OneToMany(mappedBy = "user")
    private List<Device> deviceList;


    public User(String name, String surname, String email, String username) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
    }
}
