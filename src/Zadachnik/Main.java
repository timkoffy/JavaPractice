package Zadachnik;

public class Main {
    public static void main(String[] args) {
//        // ====== 1.1.x ======
//
//        // 1.1.1.
//        System.out.println("1.1.1. cущность Точка в двух плоскостях");
//
//        Point point1 = new Point(0, 0);
//        Point point2 = new Point(3, 2);
//        Point point3 = new Point(0, 1);
//
//        System.out.println(point1);
//        System.out.println(point2);
//        System.out.println(point3);
//
//        System.out.println();
//
//        // 1.1.2.
//        System.out.println("1.1.2. cущность Человек");
//
//        Human human1 = new Human("Клеопатра", 152);
//        Human human2 = new Human("Пушкин", 167);
//        Human human3 = new Human("Александр", 189);
//
//        System.out.println(human1);
//        System.out.println(human2);
//        System.out.println(human3);
//
//        System.out.println();
//
//        // 1.1.3.
//        System.out.println("1.1.3. cущность Имя");
//
//        Name name1 = new Name("", "Клеопатра", "");
//        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
//        Name name3 = new Name("Маяковский", "Владимир", "");
//
//        System.out.println(name1);
//        System.out.println(name2);
//        System.out.println(name3);
//
//        System.out.println();
//
//        // 1.1.4.
//        System.out.println("1.1.4. cущность Время");
//
//        Time time1 = new Time(10);
//        Time time2 = new Time(10000);
//        Time time3 = new Time(100000);
//
//        System.out.println(time1);
//        System.out.println(time2);
//        System.out.println(time3);
//
//        System.out.println();
//
//        // 1.1.5.
//        System.out.println("1.1.5. cущность Дом");
//
//        House house1 = new House(1);
//        House house2 = new House(5);
//        House house3 = new House(23);
//
//        System.out.println(house1);
//        System.out.println(house2);
//        System.out.println(house3);
//
//        System.out.println();

//        // ====== 1.2.x ======
//
//        // 1.2.1.
//        System.out.println("1.2.1. cущность Линия.");
//
//        Line line1 = new Line(1, 3, 23, 8);
//        Line line2 = new Line(5, 10, 25, 10);
//        Line line3 = new Line(line1.getBegin(), line2.getEnd());
//
//        System.out.println(line1);
//        System.out.println(line2);
//        System.out.println(line3);
//
//        System.out.println();
//        line1.setBegin(0, 0);
//        line2.setEnd(15, 15);
//
//        System.out.println(line1);
//        System.out.println(line2);
//        System.out.println(line3);
//
//        System.out.println();
//        line1.setEnd(0, 30);
//
//        System.out.println(line1);
//        System.out.println(line2);
//        System.out.println(line3);
//
//        System.out.println();
//
//        // 1.2.2.
//        System.out.println("1.2.2. Человек в комбинации с Именем.");
//
//        Human human1 = new Human(
//                new Name(
//                    "",
//                    "Клеопатра",
//                    ""),
//                152);
//        Human human2 = new Human(
//                new Name(
//                        "Пушкин",
//                        "Александр",
//                        "Сергеевич"),
//                167);
//        Human human3 = new Human(
//                new Name(
//                    "Маяковский",
//                    "Владимир",
//                    ""),
//                189);
//
//        System.out.println(human1);
//        System.out.println(human2);
//        System.out.println(human3);
//
//        System.out.println();
//
//        // 1.2.3.
//        Human human4 = new Human(new Name("Чудов", "Иван", ""));
//        Human human5 = new Human(new Name("Чудов", "Петр", ""), human4);
//        Human human6 = new Human(new Name("", "Борис", ""), human5);
//
//        System.out.println(human4);
//        System.out.println(human5);
//        System.out.println(human6);
//
//        System.out.println();
//
//        // 1.2.4.
////        Department d1 = new Department("IT");
////        Department d2 = new Department("HR");
////
////        Employee employee1 = new Employee("Петров");
////        Employee employee2 = new Employee("Козлов");
////        Employee employee3 = new Employee("Сидоров");
////
//////        d.addEmployee(employee2);
//////        d.removeEmployee(employee3);
//////        d.addEmployee(employee3);
//////        d.removeEmployee(employee3);
////
////        employee1.setDepartment(d1);
////        employee1.setDepartment(d2);
////
////        System.out.println(employee1);
////        System.out.println(employee2);
////        System.out.println(employee3);
////
////        System.out.println();
//
//        // ====== 1.3.x ======
//
//        // 1.3.1.
//        System.out.println("1.3.1. cущность Студент.");
//
//        Student s1 = new Student("Вася", 3, 4, 5);
//        Student s2 = new Student("Петя", s1.getGrades());
//        Student s3 = new Student("Андрей", 5, 5, 5);
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//
//        s1.setGrade(0, 5);
//        System.out.println();
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//
//        System.out.println();
//
//        // 1.3.2.
//        System.out.println("1.3.2. cущность Ломаная линия.");
//
//        PolyLine pl1 = new PolyLine(
//                new Point(1, 5),
//                new Point(2, 8),
//                new Point(5, 3));
//
//        PolyLine pl2 = new PolyLine(
//                pl1.getBegin(),
//                new Point(2, -5),
//                new Point(4, -8),
//                pl1.getEnd());
//
//        System.out.println(pl1);
//        System.out.println(pl2);
//
//        pl1.setPoint(0, 19, 51);
//        System.out.println();
//
//        System.out.println(pl1);
//        System.out.println(pl2);
//
//        System.out.println();
//
//        // 1.3.3.
//        System.out.println("1.3.3. Cущность Город.");
//
//        Town townA = new Town("A");
//        Town townB = new Town("B");
//        Town townC = new Town("C");
//        Town townD = new Town("D");
//        Town townE = new Town("E");
//        Town townF = new Town("F");
//
//        townA.addRoute(townF, 1);
//        townA.addRoute(townB, 5);
//        townA.addRoute(townD, 6);
//
//        townF.addRoute(townB, 1);
//        townF.addRoute(townE, 2);
//
//        townE.addRoute(townF, 2);
//
//        townB.addRoute(townA, 5);
//        townB.addRoute(townC, 3);
//
//        townC.addRoute(townB, 3);
//        townC.addRoute(townD, 4);
//
//        townD.addRoute(townC, 4);
//        townD.addRoute(townE, 2);
//        townD.addRoute(townA, 6);
//
//        System.out.println(townA);
//        System.out.println();
//
//        // 1.3.4.
//        System.out.println("1.3.4. Список сотрудников отдела.");
//
////        System.out.println(d.getEmployes());
//
//        System.out.println();
//
//        // ====== 1.4.x ======
//
//        // 1.4.1.
//        Point p1 = new Point(3, 5);
//        Point p2 = new Point(25, 6);
//        Point p3 = new Point(7, 8);
//
//        System.out.println(p1 + ", " + p2 + ", " + p3);
//
//        System.out.println();
//
//        // 1.4.3.
//        PolyLine pl4 = new PolyLine(p1, p2, p3);
//
//        System.out.println(pl4);
//
//        System.out.println();
//
//        // 1.4.4.
//        House house1 = new House(2);
//        House house2 = new House(35);
//        House house3 = new House(91);
//
//        // house1.floorCount = 1000;
//
//        System.out.println(house1);
//        System.out.println(house2);
//        System.out.println(house3);
//
//        System.out.println();
//
//        // 1.4.5.
//        Name name1 = new Name("Бонифатьевич", "Христофор", "");
//
//        System.out.println(name1);
//
//        System.out.println();
//
//        // 1.4.6.
//        Human human7 = new Human("Лев");
//        Human human8 = new Human(
//                new Name(
//                        "Пушкин",
//                        "Сергей",
//                        ""),
//                human7);
//        Human human9 = new Human("Александр", human8);
//
//        System.out.println(human7);
//        System.out.println(human8);
//        System.out.println(human9);
//
//        System.out.println();
//
//        // 1.4.7.
//        System.out.println(new Student("Вася", 3, 4, 5));
//        System.out.println(new Student("Максим"));
//
//        System.out.println();
//
//        // 1.4.8.
//        System.out.println(new Town("Саратов"));
//        System.out.println(
//                new Town(
//                        "Москва",
//                        new Route(townA),
//                        new Route(townB)
//                ));
//
//        System.out.println();
//
//        // ====== 1.5.x ======
//
//        // 1.5.1.
//        System.out.println("1.5.1. Сущность Пистолет.");
//
//        Gun gun = new Gun(3);
//        for (int i = 0; i < 5; i++) {
//            gun.fire();
//        }
//
//        System.out.println();
//
//        // 1.5.2.
//        System.out.println("1.5.4. Сущность Кот.");
//
//        Cat cat = new Cat("Барсик");
//        cat.meow();
//        cat.meow(3);
//
//        System.out.println();
//
//        // 1.5.4.
//        System.out.println("1.5.4. Отец моего отца.");
//
//        Human h1 = new Human(
//                new Name(
//                        "Иванов",
//                        "Иван",
//                        "Иванович"));
//        Human h2 = new Human(
//                new Name(
//                        "",
//                        "Олег",
//                        ""),
//                h1);
//        Human h3 = new Human(
//                new Name(
//                        "",
//                        "Степан",
//                        ""),
//                h2);
//
//        System.out.println(h3.getLastName());
//
//        System.out.println();
//
//        // 1.5.5.
//        System.out.println("1.5.5. Сущность  Дробь.");
//
//        Decimal f1 = new Decimal(1, 3);
//        Decimal f2 = new Decimal(2, 3);
//        Decimal f3 = new Decimal(1, -2);
//
//        System.out.println(f1 + " * " + f2 + " = " + f1.mul(f2));
//
//        // 1/3 + 2/3 = 1
//        // 1 / -1/2 = 2
//        // 2 - 5 = -3
//        System.out.println(f1.add(f2).div(f3).sub(5));
//
//        System.out.println();
//
//        // 1.5.6.
//        System.out.println(s1.getAvgGrade() + " " + s1.isExcellent());
//        System.out.println(s2.getAvgGrade() + " " + s2.isExcellent());
//        System.out.println(s3.getAvgGrade() + " " + s3.isExcellent());
//
//        System.out.println();
//
//        // 1.5.8.
//        System.out.println("1.5.8. Сущность  Квадрат.");
//
//        Square sq1 = new Square(5,3,23);
//
//        PolyLine plFromSq1 = sq1.toPolyLine();
//        System.out.println(plFromSq1.length());
//
//        plFromSq1.setEnd(15,25);
//        System.out.println(plFromSq1.length());
//
//        System.out.println();

        // ---

        // 1.6.9.
        BidirectionalTown townC = new BidirectionalTown("C");
        BidirectionalTown townA = new BidirectionalTown("A");
        BidirectionalTown townB = new BidirectionalTown("B", new Route(townA), new Route(townC));

        System.out.println(townA);
        System.out.println(townB);
        System.out.println(townC);
        System.out.println();

        townB.addRoute(townA, 1);

        System.out.println(townA);
        System.out.println(townB);
        System.out.println(townC);
        System.out.println();

        // 1.6.10.
        Department d1 = new Department("IT");
        Department d2 = new Department("HR");

        Employee employee1 = new Employee("Петров");
        Employee employee2 = new Employee("Козлов");
        Employee employee3 = new Employee("Сидоров");

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println();

        d1.addEmployee(employee2);
        d1.addEmployee(employee3);

        employee2.setDepartment(d2);
        employee1.setDepartment(d1);

        d1.setBoss(employee2);

        employee2.setDepartment(d2);

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println();


    }
}
