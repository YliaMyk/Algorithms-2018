package lesson6;

import kotlin.NotImplementedError;

import  java.util.*;
import  java.io.IOException;
import  java.nio.file.Files;
import  java.nio.file.Paths;
import static java.lang.Integer.min;
@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    public static String longestCommonSubSequence(String first, String second) {
        throw new NotImplementedError();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Средняя
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        throw new NotImplementedError();
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Сложная
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    //Ресурсоемкость = O(N)
    //Трудоемкость = O(N^2)
    public static int shortestPathOnField(String inputName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputName));
        int height = lines.size();
        int width = lines.get(0).split("\\s+").length;
        List<int[]> list = new ArrayList<>();
        for (String line : lines) {
            int[] ints = new int[10];
            int count = 0;
            for (String s : line.split("\\s+")) {
                int i = Integer.parseInt(s);
                if (ints.length == count) ints = Arrays.copyOf(ints, count * 2);
                ints[count++] = i;
            }
            ints = Arrays.copyOfRange(ints, 0, count);
            list.add(ints);
        }
        int[][] field = list.toArray(new int[0][]);
        for (int i = 1; i < height; i++) field[i][0] = field[i - 1][0] + field[i][0];
        for (int i = 1; i < width; i++) field[0][i] = field[0][i - 1] + field[0][i];
        for (int y = 1; y < height; y++) {
            for (int x = 1; x < width; x++) {
                int minimal = min(Math.min(field[y - 1][x], field[y][x - 1]), field[y - 1][x - 1]);
                field[y][x] += minimal;
            }
        }
        return field[height - 1][width - 1];
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
