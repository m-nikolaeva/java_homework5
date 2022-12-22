import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. */

public class task1 {
    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();
        phonebook.put("89991000000", "Иван Иванов");
        phonebook.put("89990200000", "Наталья Круглова");
        phonebook.put("89990030000", "Петр Петров");
        phonebook.put("89990004000", "Анна Анина");
        phonebook.put("89990000500", "Инна Морозова");
        phonebook.put("89990000060", "Иван Иванов");
        phonebook.put("89990000007", "Петр Петров");
        phonebook.put("89990000080", "Петр Петров");
        phonebook.put("89990000900", "Иван Иванов");
        phonebook.put("89990321000", "Наталья Круглова");
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите имя и фамилию абонента (например: Иван Иванов): ");
        String nameSurname = myScan.nextLine();
        for (Map.Entry<String, String> entry: phonebook.entrySet()){
            if (entry.getValue().equals(nameSurname)){
                System.out.println(entry.getKey());
            }
        }
        myScan.close(); 
    }
}
