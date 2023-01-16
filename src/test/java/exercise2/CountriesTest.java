package exercise2;

import exercise2.dto.CountryDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountriesTest {

    @Test
    private ArrayList<CountryDTO> getCountryDTOS() {
        ArrayList<CountryDTO> countries = new ArrayList<>();
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountry("EN");
        String language = "en";
        countryDTO.getLanguages().add(language);
        countries.add(countryDTO);
        CountryDTO countryDTO2 = new CountryDTO();
        countryDTO2.setCountry("ES");
        String language2 = "es";
        countryDTO2.getLanguages().add(language2);
        countries.add(countryDTO2);
        CountryDTO countryDTO3 = new CountryDTO();
        countryDTO3.setCountry("BE");
        String language3 = "nl";
        String language4 = "fr";
        String language5 = "de";
        countryDTO3.getLanguages().add(language3);
        countryDTO3.getLanguages().add(language4);
        countryDTO3.getLanguages().add(language5);
        countries.add(countryDTO3);
        CountryDTO countryDTO4 = new CountryDTO();
        countryDTO4.setCountry("DE");
        String language6 = "de";
        countryDTO4.getLanguages().add(language6);
        countries.add(countryDTO4);
        return countries;
    }

    @Test
    @DisplayName("Verify the number of countries in the world")
    public void verifyNumberOfCountries(){
        ArrayList<CountryDTO> countries = getCountryDTOS();
        assertEquals(4, countNumberofCountries(countries));
    }
    @Test
    @DisplayName("Verify the count of the official languages")
    public void verifyCountOfficialLanguages(){
        ArrayList<CountryDTO> countries = getCountryDTOS();
        assertEquals(5, countOfficialLanguages(countries));
    }
    @Test
    @DisplayName("Verify the country with most official languages when spoken de")
    public void verifyTheCountrywithMostOfficialLanguagesWhenSpeakDe(){
        ArrayList<CountryDTO> countries = getCountryDTOS();
        assertEquals("BE", findsTheCountryOfficialLanguages(countries));
    }
    @Test
    @DisplayName("Verify the country with higher languages")
    public void verifyTheCountrywithHigherLanguages(){
        ArrayList<CountryDTO> countries = getCountryDTOS();
        assertEquals("BE", findsTheCountryHighterLanguages(countries));
    }

    @Test
    @DisplayName("Verify the country with most official languages")
    public void verifyTheCommonOfficialLanguage(){
        ArrayList<CountryDTO> countries = getCountryDTOS();
        assertEquals("[de]", findsTheCommonOfficialLanguages(countries));
    }

    /**
     * count the number of countries in the world
     * @param countries
     * @return count of the countries
     */
    @Disabled
    private int countNumberofCountries(ArrayList<CountryDTO> countries) {
        if(!countries.isEmpty() && !countries.equals(null)){
            return countries.size();
        }
        return 0;
    }

    /**
     * Count the number of languages in the world
     * @param result
     * @return the number of languages in the world
     */
    @Disabled
    private static int  countOfficialLanguages(ArrayList<CountryDTO> result) {
        Set<String> languages = new HashSet<>();
        if(!result.isEmpty() && !result.equals(null)){
            for(CountryDTO countryDTO: result){
                for(String language: countryDTO.getLanguages()){
                    languages.add(language);
                }
            }
            return  languages.size();
        }

        return  0;
    }

    /**
     * Finds the country with most official languages where speak de
     * @param result
     * @return country with the most official languages where speak de
     */
    @Disabled
    private static String findsTheCountryOfficialLanguages(ArrayList<CountryDTO> result){

        int bigger = 0;
        String country = "";
        Set<CountryDTO> countriesDE = result.stream().filter(a->a.getLanguages().
                stream().anyMatch(l->l.equals("de"))).collect(Collectors.toSet());

        for(CountryDTO countryDTO : countriesDE){
            if(countryDTO.getLanguages().size() > bigger){
                bigger = countryDTO.getLanguages().size();
                country = countryDTO.getCountry();
            }
        }

        if(country != null && !country.equals("")){
            return country;
        }

        return "No country found";

    }

    /**
     * Finds the country with higher official languages
     * @param result
     * @return country with higher official languages
     */
    @Disabled
    private static String findsTheCountryHighterLanguages(ArrayList<CountryDTO> result) {
        int bigger = 0;
        String country = "";
        for (CountryDTO countryDTO : result) {
            if (countryDTO.getLanguages().size() > bigger) {
                bigger = countryDTO.getLanguages().size();
                country = countryDTO.getCountry();
            }

        }
        if(country != null && !country.equals("")){
            return country;
        }

        return "No country found";
    }

    /**
     * Finds the common official language
     * @param result
     * @return commonLanguage between the countries
     */
    @Disabled
    private static String findsTheCommonOfficialLanguages(ArrayList<CountryDTO> result) {
        String commonLanguage = result.stream().map(l->l.getLanguages()).
                collect(Collectors.groupingBy(la->la,Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .get().getKey().toString();

        if(!commonLanguage.isEmpty() && !commonLanguage.equals("")){
            return  commonLanguage;
        }
        return "Nothind found!";
    }

}