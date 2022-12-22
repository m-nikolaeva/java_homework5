import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* Пусть дан список сотрудников:Иван Иванов ( и остальные, полный текст дз будет на платформе)
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности. */

public class task2 {
    public static void main(String[] args) {
        HashMap<Integer, String> uncountedNames = new HashMap<>();
        HashMap<String, Integer> countedNames = new HashMap<>();
        int count = 0;
        String temp = "";
        String[] firstNames = new String[1];
        String[] names = new String[] {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
        "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
        "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        for(int i = 0; i < names.length; i++){
            firstNames = names[i].split(" ");
            uncountedNames.put(i, firstNames[0]);
        }
        for (Map.Entry<Integer, String> entry: uncountedNames.entrySet()){
            temp = entry.getValue();
            count = 0;
            for (Map.Entry<Integer, String> entryTwo: uncountedNames.entrySet()){
                if(entryTwo.getValue().equals(temp)){
                    count++;
                }
            }
            countedNames.put(temp,count);
        }
        System.out.println();
        System.out.println("Имена с количеством повторений:");
        System.out.println(countedNames);
        Map<String, Integer> sortedCountedNames = countedNames.entrySet().stream().sorted(Comparator.comparingInt(e->
                -e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (a, b) -> {throw new AssertionError();}, LinkedHashMap::new));
        System.out.println();
        System.out.println("Список имен, отсортированный по убыванию популярности: ");
        System.out.println(sortedCountedNames);
        System.out.println();
    }
}
