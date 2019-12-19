package by.bsu.framework.model;

import java.util.Objects;
import java.util.Optional;

public class EnterAccount {
    private String email;
    private String password;

    public EnterAccount(){}

    public EnterAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public EnterAccount setEmail(String email) {
        this.email = email;
        return null;
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterAccount that = (EnterAccount) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, password);
    }

    @Override
    public String toString() {
        return "EnterAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
