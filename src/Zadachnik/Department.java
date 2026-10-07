package Zadachnik;

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
            addEmployee(newBoss);
        }
        this.boss = newBoss;
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employes.contains(employee)) {
            return;
        }

        Department prevDepartment = employee.getDepartment();
        if (prevDepartment != null) {
            prevDepartment.removeEmployee(employee);
        }

        employes.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(Employee employee) {
        if (employee == null) {
            return;
        }

        if (employes.contains(employee)) {
            if (boss == employee) {
                boss = null;
            }
            employes.remove(employee);
            employee.setDepartment(null);
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
