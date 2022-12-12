package com.tauber.atfundbarber.model.test;

import com.tauber.atfundbarber.model.domain.Beard;
import com.tauber.atfundbarber.model.exception.BeardToLongException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;

public class BeardTest {

    public static void main(String[] args) {

        try {
            var beard = new Beard("Super Beard", 200.0, true, "Normal_Long", 15, "Soft");
            System.out.println("Full Value: " + beard.getFullValue());
            System.out.println("Beard: " + beard);
        } catch (PriceZeroException | BeardToLongException e) {
            System.out.println(e.getMessage());
        }

        try {
            var beard2 = new Beard("Supimpa Beard", 100, true, "Little", 15, "Weird");
            System.out.println("Beard: " + beard2);
        } catch (PriceZeroException | BeardToLongException e) {
            System.out.println(e.getMessage());
        }

    }
}
