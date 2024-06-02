package migration.example.resource;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static migration.example.MigrationExampleApplication.LOG;

@RestController
public class AnyResource {

    @GetMapping("/sum")
    public ResponseEntity<Integer> sum(
            @RequestParam(name = "n1") Integer n1,
            @RequestParam(name = "n2") Integer n2) {
        LOG.info("received numbers: {} and {}", n1, n2);
        return ResponseEntity.ok(n1 + n2);
    }

    @SneakyThrows
    @PostMapping("/compress/zip")
    public ResponseEntity<byte[]> zip(@RequestBody String payload) {
        LOG.info("received payload: {}", payload);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            try (ZipOutputStream zipOut = new ZipOutputStream(baos);
                 ByteArrayInputStream is = new ByteArrayInputStream(payload.getBytes())) {
                ZipEntry zipEntry = new ZipEntry("payload.txt");
                zipOut.putNextEntry(zipEntry);
                IOUtils.copy(is, zipOut);
            }

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", "application/zip");
            headers.add("Content-Length", String.valueOf(baos.toByteArray().length));

            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
        } finally {
            baos.close();
        }
    }
}
