package peaksoft;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import peaksoft.enums.CountryName;
import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.repositories.impl.AddressRepository;
import peaksoft.repositories.impl.CountryRepository;
import peaksoft.repositories.impl.ProgrammerRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        CountryRepo countryRepo = new CountryRepository();
//        AddressRepo addressRepo = new AddressRepository();
//        countryRepo.save(new Country(CountryName.RUSSIA, "This is very big country"));
//        countryRepo.save(new Country(CountryName.KYRGYZSTAN, "This is very big country"));
//        Address address = new Address("Batken", "Zardaly", 5);
//        Address address1 = new Address("Batken", "Abdyrahmanova", 2);
//        ArrayList<Address> addresses = new ArrayList<>(Arrays.asList(address1, address));
//        List<Long> longs = new ArrayList<>(Arrays.asList(1L, 2L));
//        addressRepo.saveAll(addresses, longs);
//        System.out.println(addressRepo.findByCountry(CountryName.RUSSIA));
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Country country = applicationContext.getBean("country", Country.class);
        final CountryRepository countryRepo = applicationContext.getBean("countryRepo", CountryRepository.class);
        final AddressRepository addressRepo = applicationContext.getBean("addressRepo", AddressRepository.class);
        final ProgrammerRepository programmerRepo = applicationContext.getBean("programmerRepo", ProgrammerRepository.class);
        countryRepo.save(country);
        final Address address = applicationContext.getBean("address", Address.class);
        addressRepo.save(address, 1L);
        final Programmer programmer = applicationContext.getBean("programmer", Programmer.class);
        programmerRepo.save(programmer, 1L);
        //   System.out.println(addressRepo.findByCountry(CountryName.KAZAKSTAN));

        System.out.println(programmerRepo.findByProgrammerCountry(CountryName.KAZAKSTAN));

    }
}
