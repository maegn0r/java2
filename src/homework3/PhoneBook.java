package homework3;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<PhoneBookRecord> phoneBook;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
        phoneBook.add(new PhoneBookRecord("Иванов", 79062820023L));
        phoneBook.add(new PhoneBookRecord("Петров", 79264822582L));
        phoneBook.add(new PhoneBookRecord("Сидоров", 79163521232L));
        phoneBook.add(new PhoneBookRecord("Щукин", 79031128242L));
        phoneBook.add(new PhoneBookRecord("Коровин", 79012528282L));
        phoneBook.add(new PhoneBookRecord("Соколов", 79162531732L));
        phoneBook.add(new PhoneBookRecord("Соколов", 79162531532L));
        phoneBook.add(new PhoneBookRecord("Соколов", 79162531632L));
        phoneBook.add(new PhoneBookRecord("Машков", 79162531532L));
        phoneBook.add(new PhoneBookRecord("Козлов", 79162531632L));
        phoneBook.add(new PhoneBookRecord("Розанов", 79162531132L));
        phoneBook.add(new PhoneBookRecord("Коровин", 79162531532L));
        phoneBook.add(new PhoneBookRecord("Соколов", 79253115132L));
    }

    public void add(String surname, long phoneNumber) {
        phoneBook.add(new PhoneBookRecord(surname, phoneNumber));
    }

    public void get(String surname) {
        for (PhoneBookRecord record : phoneBook) {
            if (record.getSurname().equalsIgnoreCase(surname)) {
                System.out.println(record.getSurname() + " " + record.getPhoneNumber());
            }
        }
    }
}

