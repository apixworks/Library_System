package sample;

import javafx.beans.property.SimpleStringProperty;

public class Member {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty faculty;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty dateBirth;
    private final SimpleStringProperty sex;
    private final SimpleStringProperty dateReg;

    public Member(String id, String name, String faculty,String phone, String dateBirth, String sex, String dateReg) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.faculty = new SimpleStringProperty(faculty);
        this.phone = new SimpleStringProperty(phone);
        this.dateBirth = new SimpleStringProperty(dateBirth);
        this.sex = new SimpleStringProperty(sex);
        this.dateReg = new SimpleStringProperty(dateReg);
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

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getDateBirth() {
        return dateBirth.get();
    }

    public SimpleStringProperty dateBirthProperty() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth.set(dateBirth);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getDateReg() {
        return dateReg.get();
    }

    public SimpleStringProperty dateRegProperty() {
        return dateReg;
    }

    public void setDateReg(String dateReg) {
        this.dateReg.set(dateReg);
    }
}
