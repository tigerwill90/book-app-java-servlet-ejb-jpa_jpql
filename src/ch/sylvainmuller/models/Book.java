package ch.sylvainmuller.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
//@Table(name="Book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private String editor;

    private Date year;

    /**
     * Constructor
     *
     * @param title
     * @param author
     * @param editor
     * @param year
     */
    public Book(String title, String author, String editor, Date year) {
        super();
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.year = year;

    }

    public Book(String title, String author, String editor) {
        super();
        this.title = title;
        this.author = author;
        this.editor = editor;
    }

    /**
     * Empty Constructor
     */
    public Book() {}

    /**
     * Get id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get author
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get editor
     * @return
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Set editor
     * @param editor
     */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     * Get year
     * @return
     */
    public Date getYear() {
        return year;
    }

    /**
     * Set year
     * @param year
     */
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
