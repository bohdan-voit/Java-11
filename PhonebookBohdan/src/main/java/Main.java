
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    static SubclassEmailSearcher myPhonebook= new SubclassEmailSearcher("Friends");
    static Phonebook Remove= new Phonebook();

    private void test(){
        int i;
        do{
            System.out.println("\n----------Меню--------\n");
            System.out.println("1.Додати новий контакт до телефонної книги");
            System.out.println("2.Знайти контакт");
            System.out.println("3.Список усіх контактів ");
            System.out.println("4.Допомога");
            System.out.println("5.Знайти контакт за електронною поштою");
            System.out.println("6.Видалити контакти");
            System.out.println("7.Зберегти");

            System.out.println("0.Вийти");
            System.out.print("Вибрати з меню:");

            i= InputScanner.readInteger();
            menu(i);
        }while(i!=0);
    }
    // Метод для додавання контакту в телефонну книгу
    public void addContactToPhonebook(){
        System.out.println("Ім'я: ");
        String name= InputScanner.readString();
        System.out.println("Адреса: ");
        String address= InputScanner.readString();
        System.out.println("Номер телефону: ");
        String phoneNumber= InputScanner.readString();
        System.out.println("Електронна пошта: ");
        String email= InputScanner.readString();
        System.out.println("Вік: ");
        String age= InputScanner.readString();
        myPhonebook.addItem(new ContactLarger(name,address,phoneNumber,email,age));
    }


    // метод для пошуку контакту за іменем
    public void searchByName(){
        System.out.print("Пошук за іменем: ");
        String name = InputScanner.readString();
        myPhonebook.searchItemByName(name);
    }
    //метод для пошуку контакту за електронню поштою
    public void searchByEmail(){
        System.out.print("Пошук за електронною поштою: ");
        String email = InputScanner.readString();
        myPhonebook.searchItemByEmail(email);
    }
    // Метод для виведення усіх контактів
    public void contactList() {
        myPhonebook.ItemList();
    }



    //Меню
    public void menu(int a){
        switch (a){
            case 0 :
                System.out.println("\n Допобачення!");
                break;
            case 1:
                addContactToPhonebook();
                break;
            case 2:
                searchByName();
                break;
            case 3:
                contactList();
                break;
            case 4:
                System.out.println("Потрібна допомога тоді пишіть нам на електронну пошту: help@mail.com");
                break;
            case 5:
                searchByEmail();
                break;
            case 6:
                Remove.contactremove();
                break;
            case 7:
                doOutput();
                break;
            default:
                System.out.println("Неправильне значення");
                break;
        }
    }
    // Метод для збереження інформації у файл
    private void doOutput() {
        try {
            PrintWriter pw = new PrintWriter("data.txt");
            for(Component tmp:myPhonebook.myComponents){
                for(int i = 0; i < myPhonebook.getNumberItem(); i++)
                    if(i==myPhonebook.getNumberItem()-1)
                        pw.println(tmp.getName()+";"+tmp.getAdress()+";"+tmp.getPhoneNumber()+";"+((ComponentExtended) tmp).getEmail()+";"+((ComponentExtended) tmp).getAge());

            }
            pw.close();
            System.out.println("\n*----- Дані збережено -----*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //Підключення до БД
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost3306/phonebook", "root", "bohdan");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from phonebook ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

        } catch (Exception ei){
            ei.printStackTrace();
        }


        if(args.length == 0) {
            //File f = new File(args[0]);
            File f = new File("data.txt");
            FileReader fr;
            try {
                fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String string;
                while((string = br.readLine())!= null){
                    System.out.println(string + "\n");
                    String s[]= string.split(";");
                    for(int i=0; i<s.length;i++)
                        s[i]=s[i].trim();
                    String name =s[0];
                    String address =s[1];
                    String phoneNumber =s[2];
                    String email =s[3];
                    String age =s[4];
                    myPhonebook.addItem(new ContactLarger(name,address,phoneNumber,email,age));

                }
                br.close();
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        new Main().test();
    }
}
