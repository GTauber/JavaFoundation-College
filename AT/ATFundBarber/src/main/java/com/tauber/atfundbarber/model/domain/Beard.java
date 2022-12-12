package com.tauber.atfundbarber.model.domain;

import com.tauber.atfundbarber.model.constants.Price;
import com.tauber.atfundbarber.model.exception.BeardToLongException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;

public class Beard extends Cuts {

    private String style;
    private double length;
    private String texture;

    public Beard(String name, double price, boolean isAvailable, String style, double length, String texture)
        throws PriceZeroException, BeardToLongException {
        super(name, price, isAvailable);
        this.style = style;
        if (length > 10000) throw new BeardToLongException("Beard is too long");
        this.length = length;
        this.texture = texture;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) throws BeardToLongException {
        if (length > 10000) throw new BeardToLongException("Beard is too long");
        this.length = length;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public double getFullValue() {
        return texture.equalsIgnoreCase("curly") ? Price.PRICE_BEARD + 200L : Price.PRICE_BEARD;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(style);
        sb.append(";");
        sb.append(length);
        sb.append(";");
        sb.append(texture);
        return sb.toString();
    }
}


