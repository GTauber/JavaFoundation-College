package com.tauber.atfundbarber.repository;

import com.tauber.atfundbarber.model.entity.Hair;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HairRepository extends JpaRepository<Hair, UUID> {

}