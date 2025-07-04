package constants;

import lombok.Getter;

@Getter
public enum MainPageNavigation {
    JAVASCRIPT_ALERT("JavaScript Alerts"),
    SORTABLE_DATA_TABLES("Sortable Data Tables"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_DOWNLOAD("File Download"),
    FILE_UPLOAD("File Upload"),
    BASIC_AUTH("Basic Auth");

    private final String label;

    MainPageNavigation(String label) {
        this.label = label;
    }
}
