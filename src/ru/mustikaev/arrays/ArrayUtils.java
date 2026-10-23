package ru.mustikaev.arrays;

/**
 * <p>Класс с утилитами по работе с массивами. Включает в себя такие методы как:</p>
 * <ul>
 *     <li>Конвертация типов элементов массива</li>
 *     <li>Вычисление суммы всех элементов массива</li>
 *     <li>Добавление элементов в массив</li>
 *     <li>Сортировка рядов двумерного массива (матрица) по сумме элементов</li>
 *     <li>Отрисовка массива / матрицы в консоль</li>
 * </ul>
 */
public class ArrayUtils {
    /**
     * Считает сумму всех элементов целочисленного массива.
     * @param arr целочисленный массив
     * @return целочисленная сумма всех элементов массива
     */
    public static int sum(int... arr) {
        int res = 0;

        for (int num : arr) {
            res += num;
        }

        return res;
    }


    /**
     * <p>Конвертирует массив строк в массив целых чисел:</p>
     * <pre>{@code
     * {"1", "23", "5432"} -> {1, 23, 5432}
     * }</pre>
     * @param strings массив строк состоящий из чисел в строковом представлении
     * @return целочисленный массив
     */
    public static int[] convertInt(String... strings) {
        int[] res = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            res[i] = Integer.parseInt(strings[i]);
        }

        return res;
    }


    /**
     * Добавляет элемент в конец целочисленного массива, возвращает новый массив с размером на 1 больше исходного.
     * @param num целочисленный элемент который хотим добавить в конец массива
     * @param src исходный целочисленный массив
     * @return новый целочисленный массив в который скопированы все элементы исходного и добавлен новый элемент в конец
     */
    public static int[] addLast(int num, int[] src) {
        int[] res = new int[src.length + 1];

        for (int i = 0; i < src.length; i++) {
            res[i] = src[i];
        }

        res[src.length] = num;

        return res;
    }


    /**
     * <p>Сортирует ряды в целочисленной матрице по возрастанию суммы элементов:</p>
     * <pre>{@code
     * {{9, 9, 9},      {{0, 0, 0},
     *  {1, 1, 2},  ->   {1, 1, 2},
     *  {0, 0, 0}}       {9, 9, 9}}
     * }</pre>
     * @param matrix целочисленная матрица которую сортируем
     */
    public static void sortMatrixBySum(int[][] matrix) {
        int rows = matrix.length;

        int[] sums = new int[rows];

        for (int i = 0; i < rows; i++) {
            sums[i] = sum(matrix[i]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                if (sums[i] > sums[j]) {
                    int tmpSum = sums[i];
                    sums[i] = sums[j];
                    sums[j] = tmpSum;

                    int[] tmpArray = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = tmpArray;
                }
            }
        }
    }


    /**
     * <p>Отрисовывает целочисленный массив:</p>
     * <pre>{@code
     * [1, 2, 3, 4]
     * }</pre>
     * @param arr целочисленный массив который хотим отрисовать
     */
    public static void print(int[] arr) {
        System.out.print("{");

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }

        System.out.print("}\n");
    }

    /**
     * <p>Отрисовывает целочисленную матрицу:</p>
     * <pre>{@code
     * {
     *  {1, 2, 3}
     *  {4, 5, 6}
     *  {7, 8, 9}
     * }
     * }</pre>
     * @param matrix целочисленная матрица которую хотим отрисовать
     */
    public static void printMatrix(int[][] matrix) {
        System.out.print("{\n");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(" ");
            print(matrix[i]);
        }

        System.out.print("}\n");
    }
}
