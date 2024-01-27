package Template;

import java.util.Scanner;

public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'short' for short information or 'long' for full details:");
        String type = scanner.nextLine();

        JazzInfoTemplate template = JazzInfoTemplateFactory.createTemplate(type);
        System.out.println("Enter the title of the jazz piece:");
        String title = scanner.nextLine();

        template.showInfo(title);
    }
}
