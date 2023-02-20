package com.tauber.atfundbarber.model.test;

import com.tauber.atfundbarber.model.enums.Gender;
import com.tauber.atfundbarber.model.entity.Attendance;
import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.model.exception.AttandenceWithoutBarberException;
import com.tauber.atfundbarber.model.exception.AttandenceWithoutCutsException;
import com.tauber.atfundbarber.model.exception.BeardToLongException;
import com.tauber.atfundbarber.model.exception.InvalidBarber;
import com.tauber.atfundbarber.model.exception.NoHairException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;
import com.tauber.atfundbarber.model.exception.ToMuchWiresException;
import java.util.List;

public class AttandenceTest {

    public static void main (String[] args) {

        Barber barber = null;
        try {
            barber = new Barber("Rosnald", "000000000-00", Gender.MALE);
        } catch (InvalidBarber e) {
            System.out.println(e.getMessage());
        }

        Hair hairCut = null;
        try {
            hairCut = new Hair("Super HairCut", 20.0, true, 10, 10, true);
        } catch (PriceZeroException e) {
            System.out.println(e.getMessage());
        } catch (NoHairException e) {
            System.out.println(e.getMessage());
        }

        Beard beardCut = null;
        try {
            beardCut = new Beard("Super BeardCut", 20.0, true, "Long", 10, "curly");
        } catch (PriceZeroException | BeardToLongException e) {
            System.out.println(e.getMessage());
        }

        Brow browCut = null;
        try {
            browCut = new Brow("Super BrowCut", 20.0, true, 10, 100, "black");
        } catch (PriceZeroException | ToMuchWiresException e) {
            System.out.println(e.getMessage());
        }

        Attendance attandence = null;
        try {
            attandence = new Attendance(barber, List.of(hairCut, beardCut, browCut));
            attandence.print();
        } catch (AttandenceWithoutBarberException | AttandenceWithoutCutsException e) {
            System.out.println(e.getMessage());
        }


    }

}
