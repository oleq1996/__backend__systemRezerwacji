package codeBang.cinema.testApi.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seats")
public class Seat {

    @Id
    private Integer id;
    private Integer row;
    private Integer number;
    private String section;

    public Seat(Integer id, Integer row, Integer number, String section) {
        this.id = id;
        this.row = row;
        this.number = number;
        this.section = section;
    }

    public Seat() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getNumber() {
        return number;
    }

    public String getSection() {
        return section;
    }
}
