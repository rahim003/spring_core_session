package peaksoft.repositories;

import peaksoft.models.Country;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public interface CountryRepo {
    void save(Country country);

    void saveAll(List<Country> countries);

    List<Country> findAll();

    Country findById(Long id);

    void deleteById(Long id);

    void deleteAll();

    Country update(Long id, Country country);


}
