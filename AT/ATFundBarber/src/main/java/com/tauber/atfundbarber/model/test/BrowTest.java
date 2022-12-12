package com.tauber.atfundbarber.model.test;

import com.tauber.atfundbarber.model.domain.Brow;
import com.tauber.atfundbarber.model.exception.PriceZeroException;
import com.tauber.atfundbarber.model.exception.ToMuchWiresException;

public class BrowTest {

    public static void main(String[] args) {

        try {
            var brow = new Brow("Meha HIper BrowCut", 100, true, 293, 100, "yellow");
            System.out.println("Full Value: " + brow.getFullValue());
            System.out.println(brow);
        } catch (PriceZeroException | ToMuchWiresException e) {
            System.out.println(e.getMessage());
        }

        try {
            var brow = new Brow("TheBrowCut", 200, false, 1000, 100, "black");
            System.out.println(brow);
        } catch (PriceZeroException | ToMuchWiresException e) {
            System.out.println(e.getMessage());
        }

    }

}
