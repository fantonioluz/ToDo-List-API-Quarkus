package lp;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task extends PanacheEntity {


    @NotBlank
    public String title;
    public String description;
    public boolean done;

    public static Task findByTitle(String title) {
        return find("title", title).firstResult();
    }
}
