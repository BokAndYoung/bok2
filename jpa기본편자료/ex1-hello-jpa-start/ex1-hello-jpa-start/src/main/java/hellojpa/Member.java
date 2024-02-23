package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Member")
public class Member {
    @Id
    private Long id;
    private String name;


    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
