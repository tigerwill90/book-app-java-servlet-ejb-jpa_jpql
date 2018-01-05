package ch.sylvainmuller.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;


    private String identity;
    private String password;

    /**
     * Constructor
     *
     * @param id
     * @param identity
     * @param password
     */
    public void User(Long id, String identity, String password) {
        this.id = id; this.identity = identity; this.password = password;
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
     * Get identity
     * @return
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * Set identity
     * @param identity
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * Get password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
