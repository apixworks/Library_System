package sample;

import javafx.beans.property.SimpleStringProperty;

public class Member {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty faculty;

    public Member(String id, String name, String faculty) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.faculty = new SimpleStringProperty(faculty);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getFaculty() {
        return faculty.get();
    }

    public SimpleStringProperty facultyProperty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty.set(faculty);
    }
}
