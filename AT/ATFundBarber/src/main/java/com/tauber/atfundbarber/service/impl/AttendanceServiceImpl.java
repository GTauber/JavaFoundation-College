package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.Attendance;
import com.tauber.atfundbarber.repository.AttendanceRepository;
import com.tauber.atfundbarber.service.AttendanceService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> listFullAttendnce() {
        return attendanceRepository.findAll();
    }
    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void delete(Attendance attendance) {
        attendanceRepository.delete(attendance);
    }
}
