// HelloWorld.java
import java.time.LocalDate;

public class HelloWorld {

    public static String greet(String name, LocalDate date) {
        if (name == null || name.trim().isEmpty()) {
            name = "незнакомец";
        }
        return "Привет, " + name + "! Сегодня: " + date;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Привет! Как тебя зовут?");
        String name = scanner.nextLine();
        System.out.println(greet(name, LocalDate.now()));
        scanner.close();
    }
}