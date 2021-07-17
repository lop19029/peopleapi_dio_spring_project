package one.digitalinnovation.developerapi.entity;

import lombok.*;
import one.digitalinnovation.developerapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    //Automatically assigns an id value when uploading to database
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
