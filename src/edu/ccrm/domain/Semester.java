package edu.ccrm.domain;

/**
 * Enum for academic semesters.
 * Each semester has a display name and a short code.
 */
public enum Semester {
    INTERIM("Interim", "IN"),
    FALL("Fall", "FA"),
    WINTER("Winter", "WI"),
    SPRING("Spring","SP"),
    SUMMER("Summer","SU");

    private final String displayName;
    private final String code;

    Semester(String displayName, String code) {
        this.displayName = displayName;
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return displayName + " (" + code + ")";
    }
}
