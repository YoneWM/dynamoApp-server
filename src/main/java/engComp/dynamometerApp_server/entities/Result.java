package engComp.dynamometerApp_server.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "pinchMax")
    private Double pinchMax;

    @Column(name = "palmMax")
    private Double palmMax;

    @Column(name = "examDate")
    private LocalDate examDate;

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

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}
