package eventExpress.data;

import eventExpress.selectorData.LeftNavSelector;

import java.util.ArrayList;
import java.util.List;

public class NavData {
    public static List<String> getUserNavItems(){
        return new ArrayList<String>(){
            {
                add(LeftNavSelector.HOME_NAME_BUTTON);
                add(LeftNavSelector.PROFILE_NAME_BUTTON);
                add(LeftNavSelector.DRAFT_NAME_BUTTON);
                add(LeftNavSelector.SEARCH_USERS_NAME_BUTTON);
                add(LeftNavSelector.RECURRENT_EVENTS_NAME_BUTTON);
                add(LeftNavSelector.CONTACT_US_NAME_BUTTON);
                add(LeftNavSelector.COMUNA_NAME_BUTTON);
            }
        };
    }
    public static List<String> getHomeNavItems(){
        return new ArrayList<String>(){
            {
                add(LeftNavSelector.HOME_NAME_BUTTON);

            }
        };
    }
}
