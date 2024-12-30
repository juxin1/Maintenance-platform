package edu.tute.utils;

public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_USERID = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_USERNAME = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_ROLETYPE = new ThreadLocal<>();

    public static void setCurrentId(Integer userId) {
        CURRENT_USERID.set(userId);
    }

    public static void setCurrentUsername(String username) {
        CURRENT_USERNAME.set(username);
    }

    public static void setCurrentRoleType(String roleType) {
        CURRENT_ROLETYPE.set(roleType);
    }

    public static Integer getCurrentId() {
        return CURRENT_USERID.get();
    }

    public static String getCurrentUsername() {
        return CURRENT_USERNAME.get();
    }

    public static String getCurrentRoleType() {
        return CURRENT_ROLETYPE.get();
    }

    public static void remove() {
        CURRENT_USERID.remove();
        CURRENT_USERNAME.remove();
        CURRENT_ROLETYPE.remove();
    }
}