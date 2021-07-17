package one.digitalinnovation.personapi.enums;

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
