package exercise2.dto;


import java.util.HashSet;
import java.util.Set;


public class CountryDTO {

    private String country;
    private Set<String> languages = new HashSet<>();

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }
}
