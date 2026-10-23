package ru.mustikaev.organization;

import java.util.ArrayList;
import java.util.List;

public class Department {
    static private final String UNKNOWN_DEPARTMENT_TITLE = "Неизвестный отдел";

    private String title;
    private Employee boss;
    private List<Employee> employes;

    public Department(String title, Employee boss) {
        if (title == null || title.isBlank()) {
            title = UNKNOWN_DEPARTMENT_TITLE;
        }
        this.title = title;

        this.employes = new ArrayList<>();

        if (boss != null) {
            this.boss = boss;
            employes.add(boss);
        }
    }

    public Department(String title) {
        this(title, null);
    }

    public String getTitle() {
        if (title == null || title.isBlank()) {
            title = UNKNOWN_DEPARTMENT_TITLE;
        }
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            title = UNKNOWN_DEPARTMENT_TITLE;
        }
        this.title = title;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee newBoss) {
        if (!employes.contains(newBoss)) {
            assign(newBoss, this);
        }
        this.boss = newBoss;
    }

    static void assign(Employee employee, Department target) {
        if (employee == null) {
            return;
        }

        Department current = employee.department;
        if (current == target) {
            return;
        }

        if (current != null) {
            current.employes.remove(employee);
            if (current.boss == employee) {
                current.boss = null;
            }
        }

        employee.department = target;

        if (target != null) {
            target.employes.add(employee);
        }
    }

    public void addEmployee(Employee employee) {
        assign(employee, this);
    }

    public void removeEmployee(Employee employee) {
        if (employee != null && employee.department == this) {
            assign(employee, null);
        }
    }

    public List<Employee> getEmployes() {
        return new ArrayList<>(employes);
    }

    @Override
    public String toString() {
        return "Отдел " + title +
                ", босс = " + boss +
                ", сотрудники " + employes;
    }
}
