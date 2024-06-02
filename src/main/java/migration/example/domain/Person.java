package migration.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@Builder
@ToString
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @JsonProperty
    Byte age;

    @JsonProperty
    String name;
}
