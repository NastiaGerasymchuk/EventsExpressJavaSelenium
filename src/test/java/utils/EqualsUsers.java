package utils;

import eventExpress.models.User;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Iterator;
import java.util.List;

public class EqualsUsers extends TypeSafeMatcher<User> {
    private final User user;

    public EqualsUsers(User user) {
        this.user = user;
    }

    @Override
    protected boolean matchesSafely(User givenUser) {
        return isEqualElements(user.getName(),givenUser.getName())&&
                isEqualElements(user.getBirthday(),givenUser.getBirthday())&&
                equalsSanitize(user.getCategories(),givenUser.getCategories())&&
                equalsSanitize(user.getManageNotifications(),givenUser.getManageNotifications());
    }

    @Override
    public void describeTo(Description description) {

    }
    protected boolean isEqualElements(String elem1,String elem2){
        return elem1.equalsIgnoreCase(elem2);
    }
    protected boolean equalsSanitize(List<String> l1, List<String> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        Iterator<String> i1=l1.iterator();
        Iterator<String> i2=l2.iterator();
        while(i1.hasNext()) {
            if (!removeNonAlphanumeric(i1.next()).trim().equalsIgnoreCase(removeNonAlphanumeric(i2.next()).trim())) {
                return false;
            }
        }
        return true;
    }
    private static String removeNonAlphanumeric(String str)
    {
        str = str.replace(
                "0", "")
                .replace(
                        "\\\\n", "");
        return str;
    }
    public static Matcher<User> equalsUsers(User user) {
        return new EqualsUsers(user);
    }
}
