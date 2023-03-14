package com.tauber.atfundbarber.model.loaders;

import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.service.impl.BrowServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class BrowLoader implements ApplicationRunner {

    private final BrowServiceImpl browService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String file = "brow.txt";
        try {
            var fileReader = new FileReader(file);
            var reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            String[] fields = null;

            while (line != null) {
                fields = line.split(";");
                var brow = Brow.builder()
                    .name(fields[0])
                    .price(Double.parseDouble(fields[1]))
                    .available(Boolean.parseBoolean(fields[2]))
                    .wires(Integer.parseInt(fields[3]))
                    .width(Double.parseDouble(fields[4]))
                    .color(fields[5])
                    .build();
                log.info("Saving beard: {}", brow);
                browService.save(brow);
                line = reader.readLine();
            }
            reader.close();
            fileReader.close();

            fileReader.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
