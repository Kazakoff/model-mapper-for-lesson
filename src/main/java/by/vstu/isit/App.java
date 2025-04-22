package by.vstu.isit;

import org.modelmapper.*;

import by.vstu.isit.models.Address;
import by.vstu.isit.models.Person;
import by.vstu.isit.models.PersonDto;

public class App {
    public static void main(String[] args) {
        System.out.println("______________Provider");
        TypeMap<Person, Person> personToProviderDto = new ModelMapper().createTypeMap(Person.class, Person.class);
        Provider<Person> personProvider = p -> {
            System.out.println(p);
            return Person.builder()
                    .name("MMM")
                    .age(1)
                    .address(new Address("Vit", "MM st"))
                    .build();
        };

        personToProviderDto.setProvider(personProvider);

        Person personProviderDto = personToProviderDto.map(Person.builder()
                .name("Michal")
                .age(15)
                .build());

        System.out.println(personProviderDto);

        System.out.println("______________Converter");
        TypeMap<Person, PersonDto> personToDto = new ModelMapper().createTypeMap(Person.class, PersonDto.class);

        Converter<String, String> toUppercase = new AbstractConverter<String, String>() {
            protected String convert(String source) {
                return source == null ? null : source.toUpperCase();
            }
        };

        personToDto.addMappings(mapper -> mapper.using(toUppercase).map(Person::getName, PersonDto::setFirstName));
        personToDto.addMapping(x -> x.getAddress().getCity(), PersonDto::setCity);
        personToDto.addMapping(x -> x.getAddress().getStreet(), PersonDto::setStreet);

        PersonDto personDto = personToDto.map(Person.builder()
                .name("Michal")
                .age(15)
                .address(new Address("Warsaw", "Nowy Swiat"))
                .build());

        System.out.println(personDto);
    }
}
