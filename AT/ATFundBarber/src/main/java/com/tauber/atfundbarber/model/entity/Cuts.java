package com.tauber.atfundbarber.model.entity;

import com.tauber.atfundbarber.model.exception.PriceZeroException;
import java.util.UUID;

public abstract class Cuts {

    private UUID id;

    private String name;

    private Double price;

    private boolean isAvailable;

    private Cuts() {
        this.id = UUID.randomUUID();
    }

    protected Cuts(String name, Double price, boolean isAvailable) throws PriceZeroException {
        this();
        if (price == 0) throw new PriceZeroException("Price cannot be zero");
        this.price = price;
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public abstract double getFullValue();

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(getId());
        sb.append(";");
        sb.append(getName());
        sb.append(";");
        sb.append(getPrice());
        sb.append(";");
        sb.append(isAvailable());

        return sb.toString();
    }
}
