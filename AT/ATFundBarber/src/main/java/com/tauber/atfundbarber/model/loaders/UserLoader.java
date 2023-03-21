package com.tauber.atfundbarber.model.loaders;

import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.service.impl.UserServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
@Order(-1)
public class UserLoader implements ApplicationRunner {

    private final UserServiceImpl userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String file = "user.txt";
        try {
            var fileReader = new FileReader(file);
            var reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            String[] fields = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            while (line != null) {
                fields = line.split(";");
//                create a date formatter for parse text to date

                var user = User.builder()
                    .firstName(fields[0])
                    .lastName(fields[1])
                    .userName(fields[2])
                    .dateOfBirth(LocalDate.parse(fields[3], formatter))
                    .password(fields[4])
                    .build();
                log.info("Saving user: {}", user);
                userService.saveNewUser(user);
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
