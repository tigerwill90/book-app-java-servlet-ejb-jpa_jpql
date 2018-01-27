package ch.sylvainmuller.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private String editor;

    private Date year;

    public Book(String title, String author, String editor, Date year) {
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.year = year;

    }

    /**
     * Construct a book when date is invalid or not found in request attribute
     *
     * @param title
     * @param author
     * @param editor
     */
    public Book(String title, String author, String editor) {
        this.title = title;
        this.author = author;
        this.editor = editor;
    }

    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                ", year=" + year +
                '}';
    }
}
