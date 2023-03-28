package models;

public class BaseModel {
    private Long id;
    // can also add createdAt, updatedAt, createdOn, updatedOn such details common to all tables in db

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
