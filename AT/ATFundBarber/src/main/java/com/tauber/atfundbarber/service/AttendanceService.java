package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Attendance;
import java.util.List;

public interface AttendanceService {

    List<Attendance> listFullAttendnce();

    Attendance save(Attendance attendance);

    void delete(Attendance attendance);
}
