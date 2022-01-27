package entity;

import exceptions.*;

import java.lang.reflect.Field;

public class User {
    private String surname;
    private String name;
    private int age;
    private String email;
    private String phone;

    public User(String surname, String name, int age, String email, String phone) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public User() {

    }

    public static boolean check(User user) throws UserValidException, IllegalAccessException, NoSuchFieldException {
        //        поля не должны быть равны null
        for (Field field : User.class.getDeclaredFields()) {
            if(field.get(user) == null) throw new UserValidException("can not be null");
        }

        // имя  не должны содержать числа или специальные символы
        Field nameField = User.class.getDeclaredField("name");
        String name = (String)nameField.get(user);
        if(!name.matches("[a-zA-Z]+")){
            throw new UserNameException("name must include only letters");
        }

        // фамилия не должны содержать числа или специальные символы
        Field surnameField = User.class.getDeclaredField("surname");
        String surname = (String)surnameField.get(user);
        if(!name.matches("[a-zA-Z]+")){
            throw new UserSurnameException("surname must include only letters");
        }

        Field phoneField = User.class.getDeclaredField("surname");
        String phone = (String)phoneField.get(user);
        if(!phone.matches("^([0])([0-9]){9}$")) {
            throw new UserPhoneException("phone the number must contain only digits, start from zero and must contain 10 digits");
        }

        Field emailField = User.class.getDeclaredField("surname");
        String email = (String)emailField.get(user);
        if(!email.matches("^((\\w|[-+])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$")) {
            throw new UserMailException("error Email");
        }

        if(user.age <0 || user.age > 150){
            throw new UserAgeException("age must be in range (0; 150)");
        }
        return true;
    }



}
