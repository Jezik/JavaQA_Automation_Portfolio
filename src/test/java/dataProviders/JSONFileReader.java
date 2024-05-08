package dataProviders;

import com.google.gson.Gson;
import testDataTypes.MockUser;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class JSONFileReader {
    private final String mockUsersFilePath = new File("").getAbsolutePath().concat("\\src\\test\\resources\\testData\\mock_users.json");

    public JSONFileReader() {
    }

    public List<MockUser> getMockUsersFromJSON() {
        Gson gson = new Gson();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(mockUsersFilePath));
            MockUser[] users = gson.fromJson(reader, MockUser[].class);
            reader.close();
            return Arrays.asList(users);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + mockUsersFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
