package tn.esprit.pidev.entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class AffectationRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String status; // PENDING, ACCEPTED, REJECTED, etc.

    // Constructors, getters, setters, and other methods

    // Constructor
    public AffectationRequest() {
    }

    // Constructor with parameters
    public AffectationRequest(User user, Task task, String status) {
        this.user = user;
        this.task = task;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
