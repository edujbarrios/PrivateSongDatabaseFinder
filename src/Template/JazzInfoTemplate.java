package Template;

import java.util.Map;

public abstract class JazzInfoTemplate {

    public final void showInfo(String title) {
        Map<String, String> record = processFile(title);
        if (record != null) {
            display(record);
        } else {
            System.out.println("No se encontró la información del tema solicitado.");
        }
    }

    protected abstract Map<String, String> processFile(String title);

    protected abstract void display(Map<String, String> record);
}
