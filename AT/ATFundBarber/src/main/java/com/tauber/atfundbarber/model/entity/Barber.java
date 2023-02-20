package com.tauber.atfundbarber.model.entity;

import com.tauber.atfundbarber.model.enums.Gender;
import com.tauber.atfundbarber.model.exception.InvalidBarber;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "barbers_tb")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    private String cpf;

    private Gender gender;


    public Barber(String name, String cpf, Gender gender) throws InvalidBarber {
        if(name == null || name.isBlank()) throw new InvalidBarber("Name cannot be null or empty");
        this.name = name;
        if(cpf == null || cpf.isBlank()) throw new InvalidBarber("CPF cannot be null or empty");
        this.cpf = cpf;
        if(gender == null) throw new InvalidBarber("Gender cannot be null or empty");
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
