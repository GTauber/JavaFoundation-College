package com.tauber.atfundbarber.model.test;

import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.model.exception.BeardToLongException;
import com.tauber.atfundbarber.model.exception.NoHairException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;
import com.tauber.atfundbarber.model.exception.ToMuchWiresException;

public class CutsTest {

    public static void main(String[] args) {
        try {
            var hair = new Hair("mega hiper HairCut", 100, true, 10, 10, true);
            System.out.println(hair);
        } catch (PriceZeroException | NoHairException e) {
            System.out.println(e.getMessage());
        }

        try {
            var beard = new Beard("mega hiper beardCut", 100, true, "Long", 100, "curly");
            System.out.println(beard);
        } catch (BeardToLongException | PriceZeroException e) {
            System.out.println(e.getMessage());
        }

        try {
            var brow = new Brow("mega hiper beardCut", 100, true, 293, 100, "yellow");
            System.out.println(brow);
        } catch (PriceZeroException | ToMuchWiresException e) {
            System.out.println(e.getMessage());
        }
    }

}
