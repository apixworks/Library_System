package sample;

import javafx.beans.property.SimpleStringProperty;

public class Book {
    private final SimpleStringProperty isbn;
    private final SimpleStringProperty title;
    private final SimpleStringProperty publication;
    private final SimpleStringProperty language;
    private final SimpleStringProperty category;
    private final SimpleStringProperty status;

    public Book(String isbn, String title, String publication, String language, String category, String status) {
        this.isbn = new SimpleStringProperty(isbn);
        this.title = new SimpleStringProperty(title);
        this.publication = new SimpleStringProperty(publication);
        this.language = new SimpleStringProperty(language);
        this.category = new SimpleStringProperty(category);
        this.status = new SimpleStringProperty(status);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getPublication() {
        return publication.get();
    }

    public SimpleStringProperty publicationProperty() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication.set(publication);
    }

    public String getLanguage() {
        return language.get();
    }

    public SimpleStringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
