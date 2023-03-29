package com.tauber.atfundbarber.repository;

import com.tauber.atfundbarber.model.entity.Attendance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {

}