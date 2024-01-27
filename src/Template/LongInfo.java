package Template;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongInfo extends JazzInfoTemplate {

    @Override
    protected Map<String, String> processFile(String title) {
        Map<String, String> record = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("jazz_classics.csv")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(title)) {
                    String[] headers = {"Track Name", "Artist Name(s)", "Album Name", "Album Artist Name(s)", "Album Release Date", "Disc Number", "Track Number", "Track Duration (ms)", "Track Preview URL", "Popularity"};
                    for (int i = 0; i < values.length; i++) {
                        record.put(headers[i], values[i]);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    protected void display(Map<String, String> record) {
        record.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
