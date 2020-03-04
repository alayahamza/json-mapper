import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    private static final String json = "[{\"name\":\"mkyong\", \"age\":37}, {\"name\":\"fong\", \"age\":38}]";

    public static void main(String[] args) {
        List<String> people = getNames(json);
        people.forEach(System.out::println);
    }

    public static List<String> getNames(String json) {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> people = new ArrayList<>();
        try {
            people = Arrays.asList(mapper.readValue(json, Person[].class));
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
