import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    static class Student {
        String name, grade;
        int roll;

        Student(String name, int roll, String grade) {
            this.name = name;
            this.roll = roll;
            this.grade = grade;
        }

        public String toString() {
            return name + " | Roll: " + roll + " | Grade: " + grade;
        }
    }

    List<Student> list = new ArrayList<>();
    final String FILE = "students.txt";

    public StudentManagementSystem() { load(); }

    // Add, Remove, Search, Edit
    void add(Student s) { list.add(s); save(); }
    boolean remove(int roll) { return list.removeIf(s -> s.roll == roll) && save(); }
    Student search(int roll) { return list.stream().filter(s -> s.roll == roll).findFirst().orElse(null); }
    boolean edit(int roll, String name, String grade) {
        Student s = search(roll);
        if (s != null) {
            if (!name.isEmpty()) s.name = name;
            if (!grade.isEmpty()) s.grade = grade;
            save();
            return true;
        }
        return false;
    }

    // File Save & Load
    boolean save() {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE))) {
            for (Student s : list)
                out.println(s.name + "," + s.roll + "," + s.grade);
        } catch (Exception e) { return false; }
        return true;
    }

    void load() {
        File f = new File(FILE);
        if (!f.exists()) return;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                list.add(new Student(p[0], Integer.parseInt(p[1]), p[2]));
            }
        } catch (Exception ignored) {}
    }

    // Helper
    static int validInt(Scanner sc) {
        while (!sc.hasNextInt()) { System.out.println("Enter number only!"); sc.next(); }
        int n = sc.nextInt(); sc.nextLine(); return n;
    }

    // Main Program
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentManagementSystem s = new StudentManagementSystem();

        while (true) {
            System.out.println("\n1.Add  2.Remove  3.Edit  4.Search  5.Display  6.Exit");
            System.out.print("Choose: ");
            int ch = validInt(in);

            if (ch == 1) {
                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Roll: ");
                int roll = validInt(in);
                System.out.print("Grade: ");
                String grade = in.nextLine();
                s.add(new Student(name, roll, grade));
                System.out.println("Added!");

            } else if (ch == 2) {
                System.out.print("Roll to remove: ");
                System.out.println(s.remove(validInt(in)) ? "Removed!" : "Not found");

            } else if (ch == 3) {
                System.out.print("Roll to edit: ");
                int r = validInt(in);
                System.out.print("New Name (or blank): ");
                String n = in.nextLine();
                System.out.print("New Grade (or blank): ");
                String g = in.nextLine();
                System.out.println(s.edit(r, n, g) ? "Updated!" : "Not found");

            } else if (ch == 4) {
                System.out.print("Roll to search: ");
                Student st = s.search(validInt(in));
                System.out.println(st != null ? st : "Not found");

            } else if (ch == 5) {
                s.list.forEach(System.out::println);

            } else if (ch == 6) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option!");
            }
        }
    }
}
