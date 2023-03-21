package com.tauber.atfundbarber.repository;

import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.entity.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, UUID> {

    public List<Barber> findBarberByUser(User user);

}
