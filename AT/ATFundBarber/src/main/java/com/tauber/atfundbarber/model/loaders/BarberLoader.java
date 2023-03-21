package com.tauber.atfundbarber.model.loaders;

import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.enums.Gender;
import com.tauber.atfundbarber.service.impl.BarberServiceImpl;
import com.tauber.atfundbarber.service.impl.UserServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class BarberLoader implements ApplicationRunner {

    private final BarberServiceImpl barberService;
    private final UserServiceImpl userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String file = "barber.txt";
        try {
            var fileReader = new FileReader(file);
            var reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            String[] fields = null;

            while (line != null) {
                fields = line.split(";");
                var barber = Barber.builder()
                    .name(fields[0])
                    .cpf(fields[1])
                    .gender(Gender.valueOf(fields[2]))
                    .user(userService.getUserList(Integer.parseInt(fields[3])))
                    .build();
                log.info("Saving new Barber: {}", barber);
                barberService.save(barber);
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
