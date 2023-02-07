package peaksoft.services.impl;

import peaksoft.enums.CountryName;
import peaksoft.models.Address;
import peaksoft.repositories.AddressRepo;
import peaksoft.repositories.impl.AddressRepository;
import peaksoft.services.AddressService;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo = new AddressRepository();

    @Override
    public String save(Address address, Long countryId) {
        addressRepo.save(address, countryId);
        return "SUCCESSFULLY SAVE";
    }

    @Override
    public String saveAll(List<Address> addresses, List<Long> countriesId) {
        addressRepo.saveAll(addresses, countriesId);
        return "SUCCESSFULLY SAVES SAVE ALL";
    }

    @Override
    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepo.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        addressRepo.deleteById(id);
        return "SUCCESSFULLY WORK THIS METHOD";
    }

    @Override
    public String deleteAll() {
        addressRepo.deleteAll();
        return "COOL";
    }

    @Override
    public Address update(Long id, Address address) {
        return null;
    }

    @Override
    public List<Address> findByCountry(CountryName countryName) {
        return addressRepo.findByCountry(countryName);
    }
}
