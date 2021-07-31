package homework3;

import java.util.ArrayList;
import java.util.List;

public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Кулагин", 79028384732L);

        printListOfNumbers(phoneBook.get("КуЛаГиН"));
        printListOfNumbers(phoneBook.get("Соколов"));

    }
    public static void printListOfNumbers(List<Long> list){
        for (Long number : list) {
            System.out.println(number);
        }
        System.out.println();
    }
}
