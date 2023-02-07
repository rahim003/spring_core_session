package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

/**
 * @author kurbanov
 * @created 06/02/2023 - 12:42
 **/
@Entity
@Table(name = "programmers")
@Getter
@Setter
@NoArgsConstructor
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programmer_generator")
    @SequenceGenerator(name = "programmers_sequence", sequenceName = "programmer_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;

    private Status status;
    @ManyToMany(cascade = ALL, fetch = EAGER,mappedBy = "programmers")
    private List<Project> projects = new ArrayList<>();
    @OneToOne(cascade = {ALL}, fetch = LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    @Override
    public String   toString() {
        return "Programmer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", status=" + status +
                '}';
    }
}
