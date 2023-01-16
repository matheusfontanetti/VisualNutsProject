package exercise2;

import exercise2.dto.CountryDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Countries {
    public static void main(String[] args) {
        try {
            ArrayList<CountryDTO> result = new ArrayList<>();
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(new FileReader("src/main/java/exercise2/countries.json"));
            for(Object o : array){
                JSONObject country = (JSONObject) o;
                String name= (String) country.get("country");
                JSONArray languages = (JSONArray) country.get("languages");
                CountryDTO c = new CountryDTO();
                c.setCountry(name);
                for(Object l: languages){
                    c.getLanguages().add((String)l);
                }
                result.add(c);
            }
            int numberOfCountries  = returnCountriesInTheWorld(result);
            System.out.println("The number of countries in the world is: " + numberOfCountries);
            int countOfficiallanguages = countOfficialLanguages(result);
            System.out.println("The number of official languages is: " + countOfficiallanguages);
            String countryOfficialLanguages = findsTheCountryOfficialLanguages(result);
            System.out.println("The country with the most official language where they speak de is: " + countryOfficialLanguages);
            String countryWithHigherLanguages = findsTheCountryHighterLanguages(result);
            System.out.println("The country with the most official language where they speak de is: " + countryWithHigherLanguages);
            String commonOffcialLanguages = findsTheCommonOfficialLanguages(result);
            System.out.println("The country with the most official language where they speak de is: " + commonOffcialLanguages);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Finds the common official language
     * @param result
     * @return commonLanguage between the countries
     */
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

    /**
     * Finds the country with higher official languages
     * @param result
     * @return country with higher official languages
     */
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
     * Finds the country with most official languages where speak de
     * @param result
     * @return country with the most official languages where speak de
     */
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
     * Returns count of all official languages
     * @param result
     * @return count of all official languages
     */
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
     * Returns the number of countries in the world
     * @param result
     * @return number of countries in the world
     */
    private static int returnCountriesInTheWorld(ArrayList<CountryDTO> result) {
        if(!result.isEmpty() && !result.equals(null)){
            return result.size();
        }
        return 0;
    }
}
