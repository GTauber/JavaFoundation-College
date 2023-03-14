package com.tauber.atfundbarber.model.entity;

import static com.tauber.atfundbarber.model.constants.Price.PRICE_BROW;

import com.tauber.atfundbarber.model.exception.PriceZeroException;
import com.tauber.atfundbarber.model.exception.ToMuchWiresException;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Brow extends Cuts {

    private int wires;

    private double width;

    private String color;

    public void setWires(int wires) throws ToMuchWiresException {
        if (wires > 100) throw new ToMuchWiresException("Too much wires");
        this.wires = wires;
    }


    @Transient
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
