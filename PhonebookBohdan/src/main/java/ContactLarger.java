// Підклас класу contact для розширення змінних екземпляра електронної пошти та віку

public class ContactLarger extends Contact implements ComponentExtended {
    //	Змінні
    private String email;
    private String age;

    // Метод аксцесор для отримання електронної пошти.
    public String getEmail() {
        return email;
    }

    // Метод мутатор для встановлення електронній пошті заданого значення.
    public void setEmail(String email) {
        this.email = email;
    }

    // Метод мутатор для встановлення заданого значення віку.
    public void setAge(String age) {
        this.age = age;
    }


    // Метод доступу для отримання віку.
    public String getAge() {
        return age;
    }

    // Конструктор, який викликає конструктор суперкласу та встановлює адресу електронної пошти та вік у порожні рядки.
    public ContactLarger(){
        super();
        email="";
        age="";
    }

    // Конструктор, який викликає конструктор суперкласу та встановлює задані значення електронної пошти та віку.
    public ContactLarger(String name, String address, String phoneNumber, String email, String age){
        super(name,address,phoneNumber);
        this.email=email;
        this.age=age;
    }
}
