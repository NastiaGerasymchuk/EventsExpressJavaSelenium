package eventExpress.data;

import eventExpress.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    public static final String EMAIL="user@gmail.com";
    public static final String PASSWORD="1qaz1qaz";
    public static final String NAME="Nastia";
    public static final Gender GENDER=Gender.MALE;

    public static final String BIRTHDAY="6 Sep 2000";
    public static final List<String> CATEGORIES=new ArrayList<String>(){
        {
            add("Golf");
            add("Gaming");
            add("Fishing");
        }
    };
    public static final List<String> MANAGE_NOTIFICATIONS=new ArrayList<String>(){
        {
            add("Own Event Change");
            add("Visited Event Change");
        }
    };


}
