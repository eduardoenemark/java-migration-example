package migration.example.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static migration.example.MigrationExampleApplication.LOG;

@RestController
public class HelloResource {

    @GetMapping(path = {"/", "/ok"})
    public ResponseEntity<String> ok() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/hello")
    public ResponseEntity<String> hello(@RequestBody String name) {
        LOG.info("received name: {}", name);
        return ResponseEntity.ok(String.format("hello %s!", name));
    }
}
