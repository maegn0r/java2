package homework3;

public class PhoneBookRecord {
    private String surname;
    private long phoneNumber;

    public PhoneBookRecord(String surname, long phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

}
