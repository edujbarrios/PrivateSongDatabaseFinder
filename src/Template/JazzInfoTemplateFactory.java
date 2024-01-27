package Template;

public class JazzInfoTemplateFactory {
    public static JazzInfoTemplate createTemplate(String type) {
        if ("short".equalsIgnoreCase(type)) {
            return new ShortInfo();
        } else if ("long".equalsIgnoreCase(type)) {
            return new LongInfo();
        } else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
