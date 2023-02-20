package com.tauber.atfundbarber.repository;

import com.tauber.atfundbarber.model.entity.Brow;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrowRepository extends JpaRepository<Brow, UUID> {

}