package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * @author kurbanov
 * @created 06/02/2023 - 12:56
 **/
@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "projects_sequence", sequenceName = "programmer_seq", allocationSize = 1)
    private Long id;
    private String projectName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;

    private BigDecimal price;
    private String description;
    @ManyToMany(cascade = {DETACH, REFRESH, MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "project_programmers", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "programmers_id"))
    private List<Programmer> programmers = new ArrayList<>();

    public Project(String projectName, LocalDate dateOfStart, LocalDate dateOfFinish, BigDecimal price, String description) {
        this.projectName = projectName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfFinish=" + dateOfFinish +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
