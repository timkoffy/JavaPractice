package zadachnik;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
                // чтобы добавить атрибут точке - передаем
                // объект Property с соответствующей
                // реализацией (ColorProperty, SizeProperty):
                CustomPoint cp1 = new CustomPoint(
                        List.of(1, 2),
                        new ColorProperty("красная"),
                        new SizeProperty(4)
                );

                // при добавлении свойства, если таковое
                // имеется - просто обновляем значение.
                //
                // методы, которые объединяют в себе
                //  - добавление значения и
                //  - обновление значения
                // называют put-методами:
                cp1.putProperty(new ColorProperty("синяя"));

                System.out.println(cp1);

                // когда получаем свойство - передаем в аргументе
                // объект Class соответствующего свойства.
                //
                // делается через Объект.class:
                SizeProperty sp1 = cp1.getProperty(SizeProperty.class);
                int cp1Size = sp1.getValue();
                System.out.println(cp1Size);
        }
}
