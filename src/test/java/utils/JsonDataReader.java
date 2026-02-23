package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;

public class JsonDataReader {

    private static JsonObject jsonData;

    static {
        try {
            FileReader reader =
                    new FileReader("src/test/resources/userData.json");
            jsonData = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getData(String section, String key) {
        return jsonData
                .getAsJsonObject(section)
                .get(key)
                .getAsString();
    }

}
