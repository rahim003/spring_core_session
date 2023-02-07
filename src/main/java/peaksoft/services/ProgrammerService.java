package peaksoft.services;

import peaksoft.enums.CountryName;
import peaksoft.models.Programmer;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public interface ProgrammerService {
    String save(Programmer programmer, Long addressId);

    void saveAll(List<Programmer> programmers, List<Long> addressesId);

    List<Programmer> findAll();

    Programmer findById(Long id);

    String deleteById(Long id);

    void deleteAll();

    Programmer update(Long id, Programmer programmer);

    List<Programmer>findByProgrammerCountry(CountryName country);
}
