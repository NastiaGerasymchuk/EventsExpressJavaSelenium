package eventExpress.data;

import eventExpress.testData.NavTitle;

import java.util.ArrayList;
import java.util.List;

public class NavData {
    public static List<String> getUserNavItems(){
        return new ArrayList<String>(){
            {
                add(NavTitle.HOME_NAME_BUTTON);
                add(NavTitle.PROFILE_NAME_BUTTON);
                add(NavTitle.DRAFT_NAME_BUTTON);
                add(NavTitle.SEARCH_USERS_NAME_BUTTON);
                add(NavTitle.RECURRENT_EVENTS_NAME_BUTTON);
                add(NavTitle.CONTACT_US_NAME_BUTTON);
                add(NavTitle.COMUNA_NAME_BUTTON);
            }
        };
    }
    public static List<String> getHomeNavItems(){
        return new ArrayList<String>(){
            {
                add(NavTitle.HOME_NAME_BUTTON);

            }
        };
    }
}
