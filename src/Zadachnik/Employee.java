package Zadachnik;
// 2.1 2.2. допилить отделы
public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this(name);

        if (department != null) {
            department.addEmployee(this);
        }
        this.department = department;
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
        if (department == null) {
            this.department = null;
            return;
        }

        if (department.getEmployes().contains(this)) {
            department.removeEmployee(this);
        }

        department.addEmployee(this);
        this.department = department;
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
