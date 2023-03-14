package com.tauber.atfundbarber.model.loaders;

import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.service.impl.HairServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class HairLoader implements ApplicationRunner {

    private final HairServiceImpl hairService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String file = "hair.txt";
        try {
            var fileReader = new FileReader(file);
            var reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            String[] fields = null;

            while (line != null) {
                fields = line.split(";");
                var hair = Hair.builder()
                    .name(fields[0])
                    .price(Double.parseDouble(fields[1]))
                    .available(Boolean.parseBoolean(fields[2]))
                    .height(Double.parseDouble(fields[3]))
                    .width(Double.parseDouble(fields[4]))
                    .fade(Boolean.parseBoolean(fields[5]))
                    .build();
                log.info("Saving hair: {}", hair);
                hairService.save(hair);
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
