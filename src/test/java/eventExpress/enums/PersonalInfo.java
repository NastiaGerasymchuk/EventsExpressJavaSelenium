package eventExpress.enums;

public enum PersonalInfo {
    AVATAR(1),  //calls constructor with value 1
    USER_NAME(2),
    GENDER(3),
    DATE_OF_BIRTH(4),
    FAVOURITE_CATEGORIES(5),
    MANAGE_NOTIFICATIONS(6),
    LINKED_ACCOUNTS(7);

    private final int levelCode;

    PersonalInfo(int levelCode) {
        this.levelCode = levelCode;
    }
    public int getProgrammerCode() {
        return this.levelCode;
    }
}
