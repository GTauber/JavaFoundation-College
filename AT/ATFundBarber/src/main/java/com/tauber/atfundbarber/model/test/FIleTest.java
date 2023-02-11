package com.tauber.atfundbarber.model.test;

import com.tauber.atfundbarber.enums.Gender;
import com.tauber.atfundbarber.model.entity.Attendance;
import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.model.entity.Cuts;
import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.model.exception.AttandenceWithoutBarberException;
import com.tauber.atfundbarber.model.exception.AttandenceWithoutCutsException;
import com.tauber.atfundbarber.model.exception.BeardToLongException;
import com.tauber.atfundbarber.model.exception.InvalidBarber;
import com.tauber.atfundbarber.model.exception.NoHairException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;
import com.tauber.atfundbarber.model.exception.ToMuchWiresException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FIleTest {

    public static void main(String[] args) {
        String file = "haircuts.txt";
        String dir = "/home/gtauber/Development/College/Block 03/Java Foudations/AT/ATFundBarber/src/test/";
        try {
           var fileReader = new FileReader(file);
           var reader = new BufferedReader(fileReader);
           var fileWriter = new FileWriter("out_"+file);
           var writer = new BufferedWriter(fileWriter);

            String line = reader.readLine();
            String[] fields = null;

            var cuts = new ArrayList<Cuts>();

            Attendance attendance = null;

            while (line != null) {
                fields = line.split(";");

                switch (fields[0].toUpperCase()) {
                    case "AT":
                        try {
                            var isMale = fields[3].equalsIgnoreCase("male") ? Gender.MALE : Gender.FAMALE;
                            attendance = new Attendance(new Barber(fields[1], fields[2], isMale), cuts);
                        } catch (AttandenceWithoutCutsException | InvalidBarber | AttandenceWithoutBarberException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "H":
                        try {
                            var hairCut = new Hair(fields[1], Double.parseDouble(fields[2]), Boolean.parseBoolean(fields[3]),
                                Double.parseDouble(fields[4]),  Double.parseDouble(fields[5]), Boolean.parseBoolean(fields[6]));
                            cuts.add(hairCut);
                        } catch (PriceZeroException | NoHairException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "BR":
                        try {
                            var browCut = new Brow(fields[1], Double.parseDouble(fields[2]), Boolean.parseBoolean(fields[3]),
                                Integer.parseInt(fields[4]),  Double.parseDouble(fields[5]), fields[6]);
                            cuts.add(browCut);
                        } catch (ToMuchWiresException | PriceZeroException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "BE":
                        try {
                            var beardCut = new Beard(fields[1], Double.parseDouble(fields[2]), Boolean.parseBoolean(fields[3]),
                                fields[4],  Double.parseDouble(fields[5]), fields[6]);
                            cuts.add(beardCut);
                        } catch (PriceZeroException | BeardToLongException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid line");
                }
                line = reader.readLine();
            }
            writer.write(attendance.getLine());

            writer.close();
            reader.close();
            fileReader.close();

           fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }





}
