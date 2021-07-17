package one.digitalinnovation.developerapi.utils;

import one.digitalinnovation.developerapi.dto.request.DevDTO;
import one.digitalinnovation.developerapi.entity.Developer;
import one.digitalinnovation.developerapi.enums.ExpertiseArea;

import java.time.LocalDate;
import java.util.Collections;

public class DeveloperUtils {

    private static final String FIRST_NAME = "Alex";
    private static final String LAST_NAME = "Lopez";
    private static final String CPF_NUMBER = "081.143.605-78";
    private static final long DEV_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2021, 10, 1);
    private static final ExpertiseArea EXPERTISE_AREA = ExpertiseArea.FULLSTACK;


    public static DevDTO createFakeDTO() {
        return DevDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .technologies(Collections.singletonList(TechnologyUtils.createFakeDTO()))
                .expertiseArea(EXPERTISE_AREA)
                .build();
    }

    public static Developer createFakeEntity() {
        return Developer.builder()
                .id(DEV_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .technologies(Collections.singletonList(TechnologyUtils.createFakeEntity()))
                .expertiseArea(EXPERTISE_AREA)
                .build();
    }
}
