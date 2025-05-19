// Kyle Marlia-Conner
// 05/18/2025
// Assignment 11

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class JacksonMapExample {
    public static void main(String[] args) throws Exception {
        // Ensure JSON string is correctly formatted
        String json = "{\"name\":\"Kyle Marlia-Conner\", \"age\":\"30\"}";

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(json, Map.class);

        // Output the parsed values
        System.out.println("Name: " + map.get("name"));
        System.out.println("Age: " + map.get("age"));
    }
}
