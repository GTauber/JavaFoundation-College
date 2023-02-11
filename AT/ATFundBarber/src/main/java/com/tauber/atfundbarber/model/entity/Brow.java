package com.tauber.atfundbarber.model.entity;

import static com.tauber.atfundbarber.model.constants.Price.PRICE_BROW;

import com.tauber.atfundbarber.model.exception.PriceZeroException;
import com.tauber.atfundbarber.model.exception.ToMuchWiresException;

public class Brow extends Cuts {

    private int wires;

    private double width;

    private String color;

    public int getWires() {
        return wires;
    }

    public void setWires(int wires) throws ToMuchWiresException {
        if (wires > 100) throw new ToMuchWiresException("Too much wires");
        this.wires = wires;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getFullValue() {
        if (!this.color.equalsIgnoreCase("black")) return PRICE_BROW + 200L;
        return PRICE_BROW;
    }

    public Brow(String name, double price, boolean isAvailable, int wires, double width, String color)
        throws PriceZeroException, ToMuchWiresException {
        super(name, price, isAvailable);
        if (wires > 100) throw new ToMuchWiresException("Too much wires");
        this.wires = wires;
        this.width = width;
        this.color = color;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(wires);
        sb.append(";");
        sb.append(width);
        sb.append(";");
        sb.append(color);
        return sb.toString();
    }
}
