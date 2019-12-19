package by.bsu.framework.model;

import java.util.Objects;
import java.util.Optional;

public class PersonalInformation {

    private String name;
    private String surname;
    private String email;
    private String phone;

    public PersonalInformation(){}

    public PersonalInformation(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public PersonalInformation setName(String name) {
        this.name = name;
        return null;
    }

    public Optional<String> getSurname() {
        return Optional.ofNullable(surname);
    }

    public PersonalInformation setSurname(String surname) {
        this.surname = surname;
        return null;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public PersonalInformation setEmail(String email) {
        this.email = email;
        return null;
    }

    public Optional<String> getPhone() {
        return Optional.ofNullable(phone);
    }

    public PersonalInformation setPhone(String phone) {
        this.phone = phone;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalInformation that = (PersonalInformation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, email, phone);
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
