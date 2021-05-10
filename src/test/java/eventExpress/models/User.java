package eventExpress.models;

import eventExpress.enums.Gender;

import java.util.List;

public class User {
    private String email;
    private String password;
    private String name;
    private Gender gender;
    private String birthday;
    private List<String> categories;
    private List<String> manageNotifications;

    public User(String email,String password,String name,Gender gender,String birthday,List<String> categories,List<String> manageNotifications){
        this.email=email;
        this.password=password;
        this.name=name;
        this.gender=gender;
        this.birthday=birthday;
        this.categories=categories;
        this.manageNotifications=manageNotifications;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getManageNotifications() {
        return manageNotifications;
    }

    public Gender getGender() {
        return gender;
    }
}
