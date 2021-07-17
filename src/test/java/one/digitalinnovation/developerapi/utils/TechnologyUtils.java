package one.digitalinnovation.developerapi.utils;

import one.digitalinnovation.developerapi.dto.request.TechnologyDTO;
import one.digitalinnovation.developerapi.entity.Technology;

public class TechnologyUtils {
    private static final String TECHNOLOGY_NAME = "SpringBoot";
    private static final long TECHNOLOGY_ID = 1L;

    public static TechnologyDTO createFakeDTO() {
        return TechnologyDTO.builder()
                .name(TECHNOLOGY_NAME)
                .build();
    }

    public static Technology createFakeEntity() {
        return Technology.builder()
                .id(TECHNOLOGY_ID)
                .name(TECHNOLOGY_NAME)
                .build();
    }
}
