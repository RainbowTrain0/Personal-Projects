import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager("tasks.dat");

        manager.addTask(new Task(0, "Finish resume",      "Complete resume for CS internships",   Priority.HIGH,   LocalDate.of(2026, 3,  8), false));
        manager.addTask(new Task(0, "Read textbook",      "Chapter 7 on trees",                   Priority.MEDIUM, LocalDate.of(2026, 3, 20), false));
        manager.addTask(new Task(0, "Fix critical bug",   "NullPointerException in TaskManager",  Priority.HIGH,   LocalDate.of(2026, 3,  5), false));
        manager.addTask(new Task(0, "Clean desktop",      "Organize files and folders",           Priority.LOW,    LocalDate.of(2026, 4,  1), false));
        manager.addTask(new Task(0, "Email professor",    "Ask about office hours",               Priority.MEDIUM, LocalDate.of(2026, 3, 12), false));

        System.out.println("Sorted by Priority:");
        for (Task t : manager.sortByPriority()) {
            System.out.println(t);
        }

        System.out.println("\nSorted by Due Date:");
        for (Task t : manager.sortByDueDate()) {
            System.out.println(t);
        }
    }
}