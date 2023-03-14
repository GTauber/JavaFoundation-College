package com.tauber.atfundbarber.model.loaders;

import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.service.impl.BeardServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class BeardLoader implements ApplicationRunner {

    private final BeardServiceImpl beardService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String file = "beard.txt";
        try {
            var fileReader = new FileReader(file);
            var reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            String[] fields = null;

            while (line != null) {
                fields = line.split(";");
                var beard = Beard.builder()
                        .name(fields[0])
                        .price(Double.parseDouble(fields[1]))
                        .available(Boolean.parseBoolean(fields[2]))
                        .style(fields[3])
                        .length(Double.parseDouble(fields[4]))
                        .texture(fields[5])
                        .build();
                log.info("Saving beard: {}", beard);
                beardService.save(beard);
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
