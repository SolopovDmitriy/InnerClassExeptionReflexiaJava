package main;

//import entity.Worker;

import entity.User;
import exceptions.UserValidException;

public class Main {

    public  static void testPublicStaticInnerClasses(){
        entity2.Worker.Contacts contact = new entity2.Worker.Contacts("", "");
        entity2.Worker.Address address = new entity2.Worker.Address("Ukraine", "Poltava region", "Poltava","Petrova","4","34");
        entity2.Worker w1 = new entity2.Worker("Tesla","Nikola",1, 2, address, contact);
        entity2.Worker w2 = new entity2.Worker("Tesla","Nikola",1, 2, address, contact);
        entity2.Worker w3 = new entity2.Worker("Tesla","Nikola",1, 2, address, contact);

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w3);
    }

    public  static void testPrivateNotStaticInnerClasses(){
        entity.Worker w1 = new entity.Worker("Tesla","Nikola",1, 2,
                "Ukraine", "Poltava region", "Poltava","Petrova","4","34",
                "3809904543", "Tesla@gmail.com");

        entity.Worker w2 = new entity.Worker("Tesla","Nikola",1, 2,
                "Ukraine", "Poltava region", "Poltava","Petrova","4","34",
                "3809904543", "Tesla@gmail.com");

        System.out.println(entity.Worker.uniqueId);
        System.out.println(w1);
        Object address1 = w1.getAddress();
        System.out.println(w2.getAddress());
        System.out.println(w1.getStreet());
        System.out.println(entity.Worker.Gender.MALE);
    }

    public static void testValidateUser(){
        User user = new User("cvbn", "zfg,zdhg",22, "", "");
        try {
            User.check(user);
        }catch (UserValidException | IllegalAccessException | NoSuchFieldException ex){
            System.out.println(ex);
        }

    }



    public static void main(String[] args) {
//        testPrivateNotStaticInnerClasses();
//        testPublicStaticInnerClasses();
        testValidateUser();
    }


}
