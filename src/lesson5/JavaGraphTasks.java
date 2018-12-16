package lesson5;

import kotlin.NotImplementedError;

import java.util.List;
import java.util.*;
import java.util.Set;


@SuppressWarnings("unused")
public class JavaGraphTasks {
    /**
     * Эйлеров цикл.
     * Средняя
     *
     * Дан граф (получатель). Найти по нему любой Эйлеров цикл.
     * Если в графе нет Эйлеровых циклов, вернуть пустой список.
     * Соседние дуги в списке-результате должны быть инцидентны друг другу,
     * а первая дуга в списке инцидентна последней.
     * Длина списка, если он не пуст, должна быть равна количеству дуг в графе.
     * Веса дуг никак не учитываются.
     *
     * Пример:
     *
     *      G -- H
     *      |    |
     * A -- B -- C -- D
     * |    |    |    |
     * E    F -- I    |
     * |              |
     * J ------------ K
     *
     * Вариант ответа: A, E, J, K, D, C, H, G, B, C, I, F, B, A
     *
     *  Создаем лист для ответа
     *  * Проверяем граф на связность и количество вершин нечётной степени.
     *  * если имеется две вершины нечётной степени, то в графе не существует эйлерова цикла
     *  * Для обработки этого, особого, случая просто добавим недостающее ребро, найдём эйлеров цикл и затем удалим из ответа несуществуещее ребро.
     *  * Затем алгоритмом ищется эйлеров цикл.
     *  *
     * Справка: Эйлеров цикл -- это цикл, проходящий через все рёбра
     * связного графа ровно по одному разу
     *
     */
    //Ресурсоемкость = O(N)
    //Трудоемкость = O(N)
    public static List<Graph.Edge> findEulerLoop(Graph graph) {
        List list = new ArrayList<Graph.Edge>();
        search(graph.get("A"), graph,list);
        graph.getEdges();
        return list;
    }
    public static boolean search(Graph.Vertex vertex, Graph graph, List<Graph.Edge> list) {
        if (list.size() == graph.getEdges().size()) {
            return true;
        }
        Set<Graph.Vertex> neighbors = graph.getNeighbors(vertex);
        for (Graph.Vertex i: neighbors) {
            Graph.Edge connection = graph.getConnection(vertex, i);
            if (list.contains(connection)) continue;
            list.add(connection);
            if (search(i,graph,list)) {
                return true;
            }
        }
        if (!list.isEmpty()) {
            list.remove( list.size() - 1);
        }
        return false;
    }

    /**
     * Минимальное остовное дерево.
     * Средняя
     *
     * Дан граф (получатель). Найти по нему минимальное остовное дерево.
     * Если есть несколько минимальных остовных деревьев с одинаковым числом дуг,
     * вернуть любое из них. Веса дуг не учитывать.
     *
     * Пример:
     *
     *      G -- H
     *      |    |
     * A -- B -- C -- D
     * |    |    |    |
     * E    F -- I    |
     * |              |
     * J ------------ K
     *
     * Ответ:
     *
     *      G    H
     *      |    |
     * A -- B -- C -- D
     * |    |    |
     * E    F    I
     * |
     * J ------------ K
     */

    public static Graph minimumSpanningTree(Graph graph) {
        throw new NotImplementedError();
    }

    /**
     * Максимальное независимое множество вершин в графе без циклов.
     * Сложная
     *
     * Дан граф без циклов (получатель), например
     *
     *      G -- H -- J
     *      |
     * A -- B -- D
     * |         |
     * C -- F    I
     * |
     * E
     *
     * Найти в нём самое большое независимое множество вершин и вернуть его.
     * Никакая пара вершин в независимом множестве не должна быть связана ребром.
     *
     * Если самых больших множеств несколько, приоритет имеет то из них,
     * в котором вершины расположены раньше во множестве this.vertices (начиная с первых).
     *
     * В данном случае ответ (A, E, F, D, G, J)
     *
     * Эта задача может быть зачтена за пятый и шестой урок одновременно
     */
    //Ресурсоемкость = O(N)
    //Трудоемкость = O(N)

    public static Set<Graph.Vertex> largestIndependentVertexSet(Graph graph) {
        List<Set<Graph.Vertex>> allResults = new ArrayList<>();
        graph.getVertices().forEach(vertex -> {
            Set<Graph.Vertex> preResult = new HashSet<>();
            Set<Graph.Vertex> exists = new HashSet<>();
            graph.getVertices().forEach(anotherVertex -> {
                if (!graph.getNeighbors(vertex).contains(anotherVertex) && !exists.contains(anotherVertex)) {
                    exists.addAll(graph.getNeighbors(anotherVertex));
                    preResult.add(anotherVertex);
                }
            });
            allResults.add(preResult);
        });
        Set<Graph.Vertex> result = new HashSet<>();
        for (Set<Graph.Vertex> allResult : allResults) {
            if (result.size() < allResult.size()) {
                result = allResult;
            }
        }
        return result;
    }

    /**
     * Наидлиннейший простой путь.
     * Сложная
     *
     * Дан граф (получатель). Найти в нём простой путь, включающий максимальное количество рёбер.
     * Простым считается путь, вершины в котором не повторяются.
     * Если таких путей несколько, вернуть любой из них.
     *
     * Пример:
     *
     *      G -- H
     *      |    |
     * A -- B -- C -- D
     * |    |    |    |
     * E    F -- I    |
     * |              |
     * J ------------ K
     *
     * Ответ: A, E, J, K, D, C, H, G, B, F, I
     */
    public static Path longestSimplePath(Graph graph) {
        throw new NotImplementedError();
    }
}
