//Підклас телефонної книги для розширення методу пошуку за електронною поштою.
        public class SubclassEmailSearcher extends Phonebook{

            //	Порожній конструктор
            public SubclassEmailSearcher() {

            }
            //	Конструктор, який викликає суперклас і задає ім’я.
            public SubclassEmailSearcher (String phonebookName) {
                super(phonebookName);
            }

            //Метод пошуку в телефонній книзі та повернення контакту, що відповідає даному імені.
            public void searchItemByEmail (String anEmail){
                boolean found = false;
                for(Component tmp: myComponents){
                    if(anEmail.equals(((ComponentExtended) tmp).getEmail())){
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
                    System.out.println("\n****Вибачте, не знайдено****");
                }
            }
        }





