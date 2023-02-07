package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.CountryName;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

/**
 * @author kurbanov
 * @created 06/02/2023 - 12:51
 **/
@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_generator")
    @SequenceGenerator(name = "country_sequence", sequenceName = "country_seq", allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CountryName countryName;
    private String description;
    @OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "country")
    private List<Address> addresses = new ArrayList<>();

    public Country(CountryName countryName, String description) {
        this.countryName = countryName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName=" + countryName +
                ", description='" + description + '\'' +
                '}';
    }
}
