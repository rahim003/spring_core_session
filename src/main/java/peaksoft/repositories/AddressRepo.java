package peaksoft.repositories;

import peaksoft.enums.CountryName;
import peaksoft.models.Address;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public interface AddressRepo {
    void save(Address address, Long countryId);

    void saveAll(List<Address> addresses, List<Long> countriesId);

    List<Address> findAll();

    Address findById(Long id);

    void deleteById(Long id);

    void deleteAll();

    Address update(Long id, Address address);

    List<Address> findByCountry(CountryName countryName);
}
