package src.OOPS;

import java.util.*;

public class ComparableExample {
    static class Employee implements Comparable<Employee>{
        String name;
        int age;
        int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age && salary == employee.salary && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public int compareTo(Employee e) {
            return Integer.compare(this.age, e.age);
        }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("praveen", 20, 50000));
        list.add(new Employee("akash", 18, 60000));
        list.add(new Employee("aniket", 22, 70000));

        Collections.sort(list); //sorting
        for(Employee e : list) {
            System.out.println(e.toString());
        }

        System.out.println("============================================================");

        TreeSet<Employee> set = new TreeSet<>(); // no sorting
        set.add(new Employee("praveen", 20, 50000));
        set.add(new Employee("akash", 18, 60000));
        set.add(new Employee("aniket", 22, 70000));
        for(Employee e : set) {
            System.out.println(e.toString());
        }

        System.out.println("============================================================");
        //comparator
        /*
        Used when:

You don’t own the class (can’t modify it).

You want to sort in different ways (name, age, salary, etc.).

You want to override natural ordering for one-off use.
         */

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return Integer.compare(t1.getSalary(), employee.getSalary());
            }
        };

        Collections.sort(list, comparator);
        for(Employee e : list) {
            System.out.println(e.toString());
        }
    }

}
