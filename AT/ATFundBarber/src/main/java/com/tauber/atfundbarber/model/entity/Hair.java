package com.tauber.atfundbarber.model.entity;

import static com.tauber.atfundbarber.model.constants.Price.PRICE_FADE;
import static com.tauber.atfundbarber.model.constants.Price.PRICE_HAIR;

import com.tauber.atfundbarber.model.exception.NoHairException;
import com.tauber.atfundbarber.model.exception.PriceZeroException;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hair extends Cuts{

    private double height;

    private double width;

    private boolean fade;

    public Hair(String name, double price, boolean isAvailable, double height, double width, boolean fade)
        throws PriceZeroException, NoHairException {
        super(name, price, isAvailable);
        if (height == 0 || height < 0) throw new NoHairException("Height of the hair cannot be zero");
        this.height = height;
        this.width = width;
        this.fade = fade;
    }

    @Override
    @Transient
    public double getFullValue() {
        return fade ? PRICE_HAIR +  PRICE_FADE : PRICE_HAIR;
    }

    public void setHeight(double height) throws NoHairException {
        if (height == 0 || height < 0) throw new NoHairException("Height of the hair cannot be zero");
        this.height = height;
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
        sb.append(fade);
        return sb.toString();
    }
}
