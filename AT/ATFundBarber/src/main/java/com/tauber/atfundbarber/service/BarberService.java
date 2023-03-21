package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.entity.User;
import java.util.List;

public interface BarberService {

    Barber save(Barber barber);

    List<Barber> getAllBarbers();

    List<Barber> getBarberByUser(User user);

    void delete(Barber barber);
}
