import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class DailyGoalReminder {
    private static ArrayList<String> goals = new ArrayList<>();
    private static ArrayList<Boolean> completed = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showWelcomeMessage();
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addGoal();
                    break;
                case 2:
                    viewGoals();
                    break;
                case 3:
                    markGoalCompleted();
                    break;
                case 4:
                    System.out.println("Exiting program... Have a productive day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void showWelcomeMessage() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("===================================");
        System.out.println(" Welcome to Daily Goal Reminder App ");
        System.out.println(" Current Date & Time: " + now.format(format));
        System.out.println("===================================");
    }

    private static void showMenu() {
        System.out.println("\n---- MENU ----");
        System.out.println("1. Add a new goal");
        System.out.println("2. View today’s goals");
        System.out.println("3. Mark a goal as completed");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addGoal() {
        System.out.print("Enter your new goal: ");
        String goal = sc.nextLine();
        goals.add(goal);
        completed.add(false);
        System.out.println("Goal added successfully!");
    }

    private static void viewGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals added yet!");
            return;
        }
        System.out.println("\nYour Goals for Today:");
        for (int i = 0; i < goals.size(); i++) {
            String status = completed.get(i) ? "✔ Completed" : "❌ Pending";
            System.out.println((i + 1) + ". " + goals.get(i) + " [" + status + "]");
        }
    }

    private static void markGoalCompleted() {
        viewGoals();
        if (goals.isEmpty()) return;

        System.out.print("Enter the goal number to mark as completed: ");
        int num = sc.nextInt();
        if (num <= 0 || num > goals.size()) {
            System.out.println("Invalid goal number!");
        } else {
            completed.set(num - 1, true);
            System.out.println("Goal marked as completed!");
        }
    }
}

