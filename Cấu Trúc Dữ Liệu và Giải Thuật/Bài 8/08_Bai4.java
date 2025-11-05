import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
 import java.util.*;
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        int first = Double.compare(o2.getCgpa(), o1.getCgpa());
                        if (first != 0) {
                            return first;
                        }

                        int second = o1.getName().compareTo(o2.getName());
                        if (second != 0) {
                            return second;
                        }

                        return Integer.compare(o1.getId(), o2.getId());
                    }
                }
        );
        for (String string : events) {
            String[] pairs = string.split(" ");
            if (pairs[0].equals("ENTER")) {
                String name = pairs[1];
                double cgpa = Double.parseDouble(pairs[2]);
                int id = Integer.parseInt(pairs[3]);
                Student student = new Student(id, name, cgpa);
                pq.add(student);
            } else if(pairs[0].equals("SERVED")) {
                pq.poll();
            }
        }
        List<Student> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}