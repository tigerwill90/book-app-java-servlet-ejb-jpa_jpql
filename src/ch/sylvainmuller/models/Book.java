package ch.sylvainmuller.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private String editor;

    private String year;

    /**
     * Constructor
     *
     * @param id
     * @param title
     * @param author
     * @param editor
     * @param year
     */
    public void Book(Long id, String title, String author, String editor, String year) {
        this.id = id; this.title = title; this.author = author; this.editor = editor; this.year = year;
    }

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
    public String getYear() {
        return year;
    }

    /**
     * Set year
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }
}
