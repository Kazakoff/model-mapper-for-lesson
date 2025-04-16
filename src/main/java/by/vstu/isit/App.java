package by.vstu.isit;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import by.vstu.isit.models.Address;
import by.vstu.isit.models.Person;
import by.vstu.isit.models.PersonDto;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        TypeMap<Person, PersonDto> personToDto = new ModelMapper().createTypeMap(Person.class, PersonDto.class)
                .addMapping(Person::getName, PersonDto::setFirstName)
                .addMapping(x -> x.getAddress().getCity(), PersonDto::setCity)
                .addMapping(x -> x.getAddress().getStreet(), PersonDto::setStreet);

        PersonDto personDto = personToDto.map(Person.builder()
                .name("Michal")
                .age(15)
                .address(new Address("Warsaw", "Nowy Swiat"))
                .build());
        System.out.println(personDto);
    }
}
