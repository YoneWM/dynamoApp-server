package engComp.dynamometerApp_server.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/*
pinchMax e palmMax não são obrigatórios, PORÉM AO MENOS 1 DEVE SER INSERIDA
*/

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    @Column(name = "pinchMax")
    private double pinchMax;

    @Column(name = "palmMax")
    private double palmMax;

    @Column(name = "examDate",nullable = false,updatable = false)
    private LocalDateTime examDate;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getPinchMax() {
        return pinchMax;
    }

    public void setPinchMax(Double pinchMax) {
        this.pinchMax = pinchMax;
    }

    public Double getPalmMax() {
        return palmMax;
    }

    public void setPalmMax(Double palmMax) {
        this.palmMax = palmMax;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }
}
