package codeBang.cinema.testApi.dto;

public class SeatDto {
    private Integer id;
    private Integer row;

    private Integer number;
    private String section;

    public SeatDto(Integer id, Integer row, Integer number, String section) {
        this.id = id;
        this.row = row;
        this.number = number;
        this.section = section;
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

