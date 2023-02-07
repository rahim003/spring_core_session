package peaksoft.services.impl;

import peaksoft.enums.CountryName;
import peaksoft.models.Programmer;
import peaksoft.services.ProgrammerService;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public class ProgrammerServiceImpl implements ProgrammerService {
    @Override
    public String save(Programmer programmer, Long addressId) {
        return null;
    }

    @Override
    public void saveAll(List<Programmer> programmers, List<Long> addressesId) {

    }

    @Override
    public List<Programmer> findAll() {
        return null;
    }

    @Override
    public Programmer findById(Long id) {
        return null;
    }

    @Override
    public String deleteById() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Programmer update(Long id, Programmer programmer) {
        return null;
    }

    @Override
    public List<Programmer> findByProgrammerCountry(CountryName country) {
        return null;
    }
}
