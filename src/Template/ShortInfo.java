package Template;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ShortInfo extends JazzInfoTemplate {

    @Override
    protected Map<String, String> processFile(String title) {
        Map<String, String> record = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("jazz_classics.csv")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(title)) {
                    record.put("Track Name", values[0]);
                    record.put("Artist Name(s)", values[1]);
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
        if (record != null && !record.isEmpty()) {
            System.out.println("Título: " + record.get("Track Name") + ", Autor: " + record.get("Artist Name(s)"));
        } else {
            System.out.println("Información no disponible.");
        }
    }
}
