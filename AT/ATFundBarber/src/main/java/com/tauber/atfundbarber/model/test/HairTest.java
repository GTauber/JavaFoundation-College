package com.tauber.atfundbarber.model.test;

import com.tauber.atfundbarber.model.domain.Hair;
import com.tauber.atfundbarber.model.exception.NoHairException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;

public class HairTest {

    public static void  main(String[] args) {
        try {
            var hair = new Hair("Super HairCut", 200.0, true, 10, 10, true);
            System.out.println("Full Value: " + hair.getFullValue());
            System.out.println("Hair: " + hair);
        } catch (PriceZeroException | NoHairException e) {
            System.out.println(e.getMessage());
        }

        try {
            var hair2 = new Hair("TheHairCut!", 120.0, true, 100, 100, false);
            System.out.println("Hair: " + hair2);
        } catch (PriceZeroException | NoHairException e) {
            System.out.println(e.getMessage());
        }


    }

}
