package migration.example.resource;

import migration.example.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static migration.example.MigrationExampleApplication.LOG;

@RestController
public class PersonResource {

    static Person[] persons = new Person[]{
            Person.builder().age((byte) 7).name("Miguel").build(),
            Person.builder().age((byte) 6).name("Arthur").build(),
            Person.builder().age((byte) 35).name("Luana").build(),
            Person.builder().age((byte) -1).name("Unkown").build()
    };

    @PostMapping("/person")
    public ResponseEntity<String> person(@RequestBody Person person) {
        LOG.info("received Person object: {}", person);
        return ResponseEntity.ok(person.toString());
    }

    @GetMapping("/person/{id}/xml")
    public ResponseEntity<String> xmlFormat(@PathVariable("id") Integer id) throws JAXBException {
        LOG.info("received id: {}", id);
        Person selected = id < persons.length ? persons[id] : persons[persons.length - 1];

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(selected, writer);

        return ResponseEntity.ok(writer.toString());
    }
}
