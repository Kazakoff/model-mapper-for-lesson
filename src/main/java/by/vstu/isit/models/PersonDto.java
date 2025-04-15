package by.vstu.isit.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
class PersonDto {
    String firstName;
    int age;
    String city;
    String street;
    Contact contact;
    String dateOfBirth;
}
