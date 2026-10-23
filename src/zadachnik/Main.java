package zadachnik;

import java.util.ArrayList;
import java.util.List;


public class Main {
        public static void main(String[] args) {
                Student st1 = new Student("vasya", new GradeEvenRule());
                Student st2 = new Student("petya", new Grade2To5Rule());
                Student st3 = new Student("roma", new GradeBinaryRule());

                System.out.println(st1);
                System.out.println(st2);
                System.out.println(st3);

                Student.addGradeAll(List.of(st1, st2, st3), 4);

                System.out.println(st1);
                System.out.println(st2);
                System.out.println(st3);

        }
}
