package com.tauber.atfundbarber.model.entity;

import com.tauber.atfundbarber.model.exception.PriceZeroException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public abstract class Cuts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    private Double price;

    private boolean available;

    protected Cuts(String name, Double price, boolean available) throws PriceZeroException {
        this();
        if (price == 0) throw new PriceZeroException("Price cannot be zero");
        this.price = price;
        this.name = name;
        this.available = available;
    }
    public abstract double getFullValue();

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
