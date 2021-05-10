package eventExpress.models;

import java.util.Objects;

public class PersonalInfoTextTitle {
    private String Avatar;
    private String UserName;
    private String Gender;
    private String DateOfBirth;
    private String FavouriteCategories;
    private String ManageNotifications;
    private String LinkedAccounts;
    public PersonalInfoTextTitle(String avatar,String userName,String gender,String dateOfBirth,String favouriteCategories,String manageNotifications,String linkedAccounts){
        this.Avatar=avatar;
        this.UserName=userName;
        this.Gender=gender;
        this.DateOfBirth=dateOfBirth;
        this.FavouriteCategories=favouriteCategories;
        this.ManageNotifications=manageNotifications;
        this.LinkedAccounts=linkedAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalInfoTextTitle that = (PersonalInfoTextTitle) o;
        return Objects.equals(Avatar, that.Avatar) && Objects.equals(UserName, that.UserName) && Objects.equals(Gender, that.Gender) && Objects.equals(DateOfBirth, that.DateOfBirth) && Objects.equals(FavouriteCategories, that.FavouriteCategories) && Objects.equals(ManageNotifications, that.ManageNotifications) && Objects.equals(LinkedAccounts, that.LinkedAccounts);
    }

}
