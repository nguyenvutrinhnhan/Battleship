import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String firstName = scanner.nextLine();
        String experienceYears = scanner.nextLine();
        String cuisinePreference = scanner.nextLine();

        String string1 = "The form for " + firstName + " is completed.";
        String string2 = " We will contact you if we need a chef who cooks " + cuisinePreference + " dishes";
        String string3 = " and has " + experienceYears + " years of experience.";
        System.out.print(string1 + string2 + string3);
    }
}