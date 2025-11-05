import java.util.;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

Complete the code
class StudentComparator implements ComparatorStudent {
    @Override
    public int compare(Student x, Student y) {
        int first = Double.compare(y.getCgpa(), x.getCgpa());
        if (first != 0) {
            return first;
        }

        int second = x.getFname().compareTo(y.getFname());
        if (second != 0) {
            return second;
        }

        return Integer.compare(x.getId(), y.getId());
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        ListStudent studentList = new ArrayListStudent();
        while (testCases  0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new StudentComparator());
        for (Student st  studentList) {
            System.out.println(st.getFname());
        }
    }
}



