package be.thomasmore.party.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Client {
    @Id
    private Integer id;
    private String name;
    private Date birthDate;
    private String gender;
    private Date startDate;

    public Client(Integer id, String name, Date birthDate, String gender, Date startDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        if (gender.equals("M") || gender.equals("F")){
                this.gender = gender;
            }
        this.startDate = startDate;
    }

    public Client() {
    }
}
