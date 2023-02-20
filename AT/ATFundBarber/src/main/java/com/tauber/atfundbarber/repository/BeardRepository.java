package com.tauber.atfundbarber.repository;

import com.tauber.atfundbarber.model.entity.Beard;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeardRepository extends JpaRepository<Beard, UUID> {

}