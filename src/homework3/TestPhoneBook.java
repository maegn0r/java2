package homework3;

public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Кулагин", 79028384732L);
        phoneBook.get("кУлАгИн");
        phoneBook.get("Соколов");
    }
}
