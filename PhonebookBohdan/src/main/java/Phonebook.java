// Клас для зберігання імен, адресів і номерів телефонів у телефонній книжці.
import java.util.ArrayList;


//Методи додавання імені, адреси та номера до книги та для пошуку за іменем.
public class Phonebook {
    //Instance variables:
    private String phonebookName;
    private int maxSize=100;
    ArrayList<Component> myComponents =new ArrayList<Component>();


    //	Конструктор, який присвоює ім'я порожнім рядкам.
    public Phonebook () {
        phonebookName = "";
    }


    // Конструктор, який встановлює задані значення імен телефонної книги.
    public Phonebook (String phonebookName) {
        this.phonebookName = phonebookName;
    }


    //	Метод аксцесор для отримання імен телефонної книги.
    public String getPhonebookName() {
        return phonebookName;
    }


    // Метод мутатор для встановлення імені телефонної книги заданого значення.
    public void setPhonebookName(String phonebookName) {
        this.phonebookName = phonebookName;
    }


    // Метод додавання елемента до телефонної книги
    public void addItem(Component newComponent){
        if(myComponents.size() < maxSize) {
            myComponents.add(newComponent);
        }
        else
            System.out.println("Вибачте, Пам'ять заповнена!");
    }

    // Метод для повернення наявної кількості записів у телефонній книзі
    public int getNumberItem(){
        return myComponents.size();
    }


    // Метод повернення елемента, що відповідає даній позиції.

    public Component getItemAt (int i){
        return myComponents.get(i);
    }

    //Метод для створення переліку всіх елементів телефонної книги
    public void ItemList() {
        for(Component tmp: myComponents){
            ComponentExtended tmp1=(ComponentExtended) tmp;
            System.out.println("\nІм'я: " + tmp1.getName());
            System.out.println("Адреса: " + tmp1.getAdress());
            System.out.println("Телефон: " + tmp1.getPhoneNumber());
            System.out.println("Електронна пошта: " + tmp1.getEmail());
            System.out.println("Вік: " + tmp1.getAge());
        }
    }
    //Метод для видалення всіх елементів телефонної книги
    public void  contactremove (){
        myComponents.clear();
        System.out.println("Контакти видалені");
    }


    // Метод повернення контакту, що відповідає даному імені.
    // Контакт, повинен містити усі атрибути.


    public void searchItemByName (String aName){
        boolean found = false;
        for(Component tmp: myComponents){
            if(aName.equals(tmp.getName())){
                found = true;
                System.out.println("\n****Результати пошуку****");
                System.out.println("\tІм'я:" +tmp.getName());
                System.out.println("\tАдреса:" +tmp.getAdress());
                System.out.println("\tНомер телефону:" +tmp.getPhoneNumber());
                System.out.println("\tЕлектронна пошта:" +((ComponentExtended) tmp).getEmail());
                System.out.println("\tВік:" +((ComponentExtended) tmp).getAge());
            }
        }
        if(!found){
            System.out.println("\n*Вибачте, нічого не знайдено*");
        }
    }

}









