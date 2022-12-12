package com.tauber.atfundbarber.model.domain;

import static com.tauber.atfundbarber.model.constants.Price.*;

import com.tauber.atfundbarber.model.exception.AttandenceWithoutBarberException;
import com.tauber.atfundbarber.model.exception.AttandenceWithoutCutsException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Attendance {

    private UUID id;

    private LocalDateTime date;

    private double totalValue;

    private Barber barber;

    private List<Cuts> cuts = new ArrayList<>();

    private Attendance() {
        this.id = UUID.randomUUID();
        this.date = LocalDateTime.now();
        if (date.getDayOfWeek().getValue() > 5) {
            this.totalValue = PRICE_WEEKEND + getTotalValue();
        } else {
            this.totalValue = PRICE_WEEKDAY + getTotalValue();
        }
    }

    public Attendance(Barber barber, List<Cuts> cuts)
        throws AttandenceWithoutBarberException, AttandenceWithoutCutsException {
        this();
        if(barber == null) throw new AttandenceWithoutBarberException("Barber cannot be null");
        this.barber = barber;
        if (cuts == null) throw new AttandenceWithoutCutsException("Cuts cannot be null");
        this.cuts = cuts;
    }

    public Barber getBarbeiro() {
        return barber;
    }

    public void setBarbeiro(Barber barber) {
        this.barber = barber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotalValue() {
        cuts.forEach(cut -> totalValue += cut.getFullValue());
        return totalValue;
    }

    public void print() {
        System.out.println("Attendance: " + this);
        System.out.println("Qty of products: " + cuts.size());
        System.out.println("Cuts: ");
        cuts.forEach(cut -> System.out.println(cut.getName()));
    }

    public String getLine() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.getDate().format(formato) + ";" + this.getBarbeiro().getName() + ";" + this.getTotalValue() + ";" + this.getCuts().size() + "\r\n";
    }

    public List<Cuts> getCuts() {
        return cuts;
    }

    public void setCuts(List<Cuts> cuts) {
        this.cuts = cuts;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s;%s;%s", id, date.format(formatter), getTotalValue() > 0 ? totalValue : 500);
    }
}
