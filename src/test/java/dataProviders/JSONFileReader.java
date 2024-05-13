package dataProviders;

import com.google.gson.Gson;
import testDataTypes.PageTexts;
import testDataTypes.MockUser;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class JSONFileReader {
    private final String mockUsersFilePath = new File("").getAbsolutePath().concat("\\src\\test\\resources\\testData\\mock_users.json");
    private final String pagesTextsFilePath = new File("").getAbsolutePath().concat("\\src\\test\\resources\\testData\\texts.json");

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

    public List<PageTexts> getAccountCreatedTexts() {
        Gson gson = new Gson();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(pagesTextsFilePath));
            PageTexts[] texts = gson.fromJson(reader, PageTexts[].class);
            reader.close();
            return Arrays.asList(texts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + pagesTextsFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
