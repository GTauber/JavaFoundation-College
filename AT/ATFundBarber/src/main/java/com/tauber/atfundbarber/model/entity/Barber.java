package com.tauber.atfundbarber.model.entity;

import com.tauber.atfundbarber.enums.Gender;
import com.tauber.atfundbarber.model.exception.InvalidBarber;
import java.util.UUID;

public class Barber {

    private UUID id;

    private String name;

    private String cpf;

    private Gender gender;

    private Barber() {
        this.id = UUID.randomUUID();
    }

    public Barber(String name, String cpf, Gender gender) throws InvalidBarber {
        this();
        if(name == null || name.isBlank()) throw new InvalidBarber("Name cannot be null or empty");
        this.name = name;
        if(cpf == null || cpf.isBlank()) throw new InvalidBarber("CPF cannot be null or empty");
        this.cpf = cpf;
        if(gender == null) throw new InvalidBarber("Gender cannot be null or empty");
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(";");
        sb.append(getName());
        sb.append(";");
        sb.append(getCpf());
        sb.append(";");
        sb.append(getGender());

        return sb.toString();
    }
}
