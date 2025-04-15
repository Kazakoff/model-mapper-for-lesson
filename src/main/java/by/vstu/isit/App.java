package by.vstu.isit;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        TypeMap<Person, PersonDto> personToDto = new ModelMapper().createTypeMap(Person.class, PersonDto.class)
                .addMapping(Person::getName, PersonDto::setFirstName)
                .addMapping(x -> x.getAddress().getCity(), PersonDto::setCity)
                .addMapping(x -> x.getAddress().getStreet(), PersonDto::setStreet);

        PersonDto personDto = personToDto.map(Person.builder()
                .name("Michal")
                .age(15)
                .address(new Address("Warsaw", "Nowy Swiat"))
                .build());

    }
}
