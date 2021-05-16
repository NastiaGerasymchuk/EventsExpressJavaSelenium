package utils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Iterator;
import java.util.List;

public class EqualsSanitilize extends TypeSafeMatcher<List<String>> {

        private final List<String> subString;

        private EqualsSanitilize(final List<String> subString) {
            this.subString = subString;
        }

        @Override
        protected boolean matchesSafely(final List<String> actualString) {
            Iterator<String> i1=actualString.iterator();
            Iterator<String> i2=subString.iterator();
            while(i1.hasNext()) {
               if (!removeNonAlphanumeric(i1.next()).trim().equalsIgnoreCase(removeNonAlphanumeric(i2.next()).trim())){
                                return false;
               }
            }
            return true;
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText(""+this.subString);
        }
        public static Matcher <List<String>> equalsSanitilize(List<String> list) {
            return new EqualsSanitilize(list);
        }
        private static String removeNonAlphanumeric(String str)
        {
            str = str.replace(
                    "0", "")
                    .replace(
                            "\\\\n", "");
            return str;
        }

}

