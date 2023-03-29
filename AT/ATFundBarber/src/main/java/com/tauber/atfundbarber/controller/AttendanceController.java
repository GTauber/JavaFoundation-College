package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.Attendance;
import com.tauber.atfundbarber.model.entity.Cuts;
import com.tauber.atfundbarber.service.impl.AttendanceServiceImpl;
import com.tauber.atfundbarber.service.impl.BarberServiceImpl;
import com.tauber.atfundbarber.service.impl.CutsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AttendanceController {

    private final AttendanceServiceImpl attendanceService;
    private final CutsServiceImpl cutsService;
    private final BarberServiceImpl barberService;

    @GetMapping("/listAttendance")
    public String listAttendance(Model model) {
        model.addAttribute("attendances", attendanceService.listFullAttendnce());
        model.addAttribute("cuts", cutsService.getAllCuts());
        model.addAttribute("barbers", barberService.getAllBarbers());
        return "attendance/listAttendance";
    }

    @PostMapping("/registerAttendance")
    public String registerAttendance(Model model, HttpServletRequest request) {
        model.addAttribute("attendance", attendanceService.save(Attendance.builder()
            .date(LocalDate.parse(request.getParameter("date")))
            .barber(barberService.getBarberById(request.getParameter("barber")))
            .cuts(cutsService.getAllCutsByIds(Arrays.stream(request.getParameterValues("cuts[]")).toList()))
            .build()));
        return listAttendance(model);
    }

    @PostMapping("/deleteAttendance")
    public String deleteAttendance(Model model, Attendance attendance) {
        attendanceService.delete(attendance);
        return listAttendance(model);
    }

}
