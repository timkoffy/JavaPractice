package ru.mustikaev.organization;

public class Employee {
    private String name;
    Department department;

    public Employee(String name, Department department) {
        this(name);

        Department.assign(this, department);
    }

    public Employee(String name) {
        if (name == null) {
            throw new NullPointerException("Имя сотрудника не указано");
        }
        this.name = name;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        Department.assign(this, department);
    }

    @Override
    public String toString() {
        String res = name;
        if (department != null) {
            if (department.getBoss() == this) {
                res += " начальник отдела ";
            } else {
                res += " работает в отделе ";
            }
            res += department.getTitle();
        } else {
            res += " нигде не работает";
        }

        return res;
    }
}
