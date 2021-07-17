package one.digitalinnovation.developerapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpertiseArea {

    FRONTEND("Frontend"),
    BACKEND("Backend"),
    FULLSTACK("Fullstack");

    private final String description;
}
