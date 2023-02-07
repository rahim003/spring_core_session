package peaksoft.services;

import peaksoft.enums.CountryName;
import peaksoft.models.Address;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public interface AddressService {
    String save(Address address, Long countryId);

    String saveAll(List<Address> addresses, List<Long> countriesId);

    List<Address> findAll();

    Address findById(Long id);

    String deleteById(Long id);

    String deleteAll();

    Address update(Long id, Address address);

    List<Address> findByCountry(CountryName countryName);
}
