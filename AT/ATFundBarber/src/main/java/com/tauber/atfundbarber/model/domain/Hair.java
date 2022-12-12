package com.tauber.atfundbarber.model.domain;

import static com.tauber.atfundbarber.model.constants.Price.*;

import com.tauber.atfundbarber.model.exception.NoHairException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;

public class Hair extends Cuts{

    private double height;

    private double width;

    private boolean isFade;

    public Hair(String name, double price, boolean isAvailable, double height, double width, boolean isFade)
        throws PriceZeroException, NoHairException {
        super(name, price, isAvailable);
        if (height == 0 || height < 0) throw new NoHairException("Height of the hair cannot be zero");
        this.height = height;
        this.width = width;
        this.isFade = isFade;
    }

    @Override
    public double getFullValue() {
        return isFade ? PRICE_HAIR +  PRICE_FADE : PRICE_HAIR;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws NoHairException {
        if (height == 0 || height < 0) throw new NoHairException("Height of the hair cannot be zero");
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public boolean isFade() {
        return isFade;
    }

    public void setFade(boolean fade) {
        isFade = fade;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(height);
        sb.append(";");
        sb.append(width);
        sb.append(";");
        sb.append(isFade);
        return sb.toString();
    }
}
