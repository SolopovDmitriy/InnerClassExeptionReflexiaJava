package entity;



// private inner class
public class Worker {

    private class Contacts{
        private String phone;
        private String email;

        public Contacts() {

        }

        public Contacts(String phone, String email) {
            this.phone = phone;
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Contacts{" +
                    "phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    private class Address {
        private String country;
        private String region;
        private String town;
        private String street;
        private String house;
        private String apartment;

        public Address(String country, String region, String town, String street, String house, String apartment) {
            this.country = country;
            this.region = region;
            this.town = town;
            this.street = street;
            this.house = house;
            this.apartment = apartment;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public String getApartment() {
            return apartment;
        }

        public void setApartment(String apartment) {
            this.apartment = apartment;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", region='" + region + '\'' +
                    ", town='" + town + '\'' +
                    ", house='" + house + '\'' +
                    ", apartment='" + apartment + '\'' +
                    '}';
        }
    }

    public static class Gender{
        public static final int NOT_SPECIFIED = 0;
        public static final int MALE = 1;
        public static final int FEMALE = 2;
        public static final int MIN = 0; //Минимальное значение пола
        public static final int MAX = FEMALE; //Максимальное значение пола
    }

    public static int uniqueId = 1;
    private int id;
    private String surname;
    private String name;
    private int age;
    private int gender;
    private Address address;
    private Contacts contacts;

    public Worker(String surname, String name, int age, int gender,
                  String country, String region, String town, String street, String house, String apartment,
                  String phone, String email) {
        id = uniqueId;
        uniqueId++;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = new Address(country, region, town, street, house, apartment);
        this.contacts = new Contacts(phone, email);
    }


    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        switch (gender) {
            case Gender.MALE: return "male";
            case Gender.FEMALE: return "female";
            default: return  "NOT_SPECIFIED";
        }
    }

    public void setGender(int gender) {
        if(gender > Gender.MAX || gender < Gender.MIN){
            this.gender = Gender.NOT_SPECIFIED;
        }else{
            this.gender = gender;
        }

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + getGender() +  // TODO
                ", address=" + address +
                ", contacts=" + contacts +
                '}';
    }



    public String getStreet() {
        return address.street;
    }



}
