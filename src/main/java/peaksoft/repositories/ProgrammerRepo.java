package peaksoft.repositories;

import peaksoft.enums.CountryName;
import peaksoft.models.Programmer;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public interface ProgrammerRepo {
    void save(Programmer programmer, Long addressId);

    void saveAll(List<Programmer> programmers, List<Long> addressesId);

    List<Programmer> findAll();

    Programmer findById(Long id);

    void deleteById(Long id);

    void deleteAll();

    Programmer update(Long id, Programmer programmer);

    List<Programmer>findByProgrammerCountry(CountryName country);

}
