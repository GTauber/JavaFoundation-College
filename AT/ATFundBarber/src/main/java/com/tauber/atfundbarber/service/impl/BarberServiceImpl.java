package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.repository.BarberRepository;
import com.tauber.atfundbarber.service.BarberService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;

    @Override
    public Barber save(Barber barber) {
        return barberRepository.save(barber);
    }

    @Override
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public List<Barber> getBarberByUser(User user) {
        return barberRepository.findBarberByUser(user);
    }

    @Override
    public void delete(Barber barber) {
        barberRepository.delete(barber);
    }
}
