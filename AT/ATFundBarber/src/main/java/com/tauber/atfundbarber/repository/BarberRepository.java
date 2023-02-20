package com.tauber.atfundbarber.repository;

import com.tauber.atfundbarber.model.entity.Barber;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, UUID> {

}
