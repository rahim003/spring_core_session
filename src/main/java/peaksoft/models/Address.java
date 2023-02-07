package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

/**
 * @author kurbanov
 * @created 06/02/2023 - 12:46
 **/
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_seq", allocationSize = 1)
    private Long id;
    private String regionName;
    private String street;
    private Integer homeNumber;
    @ManyToOne(cascade = {REFRESH, DETACH, MERGE})
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToOne(cascade = {REFRESH, MERGE},mappedBy = "address")
    private Programmer programmer;

    public Address(String regionName, String street, Integer homeNumber) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", street='" + street + '\'' +
                ", homeNumber=" + homeNumber +
                '}';

    }
}
