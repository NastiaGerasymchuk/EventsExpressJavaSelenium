package eventExpress.selectorData;

public class InfoSelector {
    private static final String beginPart ="/html/body/div[1]/div[3]/div/";
    private static final String TEXT="/div[1]/div[1]/p";
    private static final String BUTTON="/div[1]/div[2]";
    public static final String CHANGE_AVATAR_TEXT= beginPart+"div[1]"+TEXT;
    public static final String CHANGE_AVATAR_BUTTON= beginPart+"div[1]"+BUTTON;
    public static final String USER_NAME_TEXT= beginPart+"div[2]"+TEXT;
    public static final String USER_NAME= beginPart +"div[2]/div[1]/div[1]/p[2]";
    public static final String USER_NAME_BUTTON=beginPart+"div[2]"+BUTTON;
    public static final String INPUT_USER_NAME=beginPart+"div[2]/div[2]/div/div/div/div/p/form/div[1]/div/div/input";
    public static final String SUBMIT_USER_NAME=beginPart+"div[2]/div[2]/div/div/div/div/p/form/div[2]/button[1]";
    public static final String CLEAR_USER_NAME=beginPart+"div[2]/div[2]/div/div/div/div/p/form/div[2]/button[2]";
    public static final String GENDER_TEXT= beginPart+"div[3]"+TEXT;
    public static final String GENDER_NAME= beginPart +"div[3]/div[1]/div[1]/p[2]";
    public static final String GENDER_BUTTON= beginPart+"div[3]"+BUTTON;
    public static final String DATE_OF_BIRTH_TEXT= beginPart+"div[4]"+TEXT;
    public static final String DATE_OF_BIRTH= beginPart +"div[4]/div[1]/div[1]/p[2]";
    public static final String DATE_OF_BIRTH_BUTTON= beginPart+"div[4]"+BUTTON;
    public static final String FAVOURITE_CATEGORIES_TEXT= beginPart+"div[5]"+TEXT;
    public static final String FAVOURITE_CATEGORIES_ITEMS="#panel4bh-header > div.MuiExpansionPanelSummary-content > p > div";
    public static final String FAVOURITE_CATEGORIES_BUTTON= beginPart+"div[5]"+BUTTON;
    public static final String MANAGE_NOTIFICATIONS_TEXT= beginPart+"div[6]"+TEXT;
    public static final String MANAGE_NOTIFICATIONS_ITEMS="#panel5bh-header > div.MuiExpansionPanelSummary-content > p > div";
    public static final String MANAGE_NOTIFICATIONS_BUTTON= beginPart+"div[6]"+BUTTON;
    public static final String LINKED_ACCOUNTS_TEXT= beginPart+"div[7]"+TEXT;
    public static final String LINKED_ACCOUNTS_BUTTON= beginPart+"div[7]"+BUTTON;





}
