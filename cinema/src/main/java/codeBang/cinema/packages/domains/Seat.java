package codeBang.cinema.packages.domains;

import javax.persistence.*;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setSection(String section) {
        this.section = section;
    }

}
