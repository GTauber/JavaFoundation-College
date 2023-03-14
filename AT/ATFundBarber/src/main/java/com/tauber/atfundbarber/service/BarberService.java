package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Barber;
import java.util.List;

public interface BarberService {

    Barber save(Barber barber);

    List<Barber> getAllBarbers();

    void delete(Barber barber);
}
