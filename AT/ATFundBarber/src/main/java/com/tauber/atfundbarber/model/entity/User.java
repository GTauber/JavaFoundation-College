package com.tauber.atfundbarber.model.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users_tb")
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private LocalDate dateOfBirth;
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Barber> barbers = new ArrayList<>();
    @Embedded
    private Address address;


    @Embeddable
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "cep",
        "logradouro",
        "complemento",
        "bairro",
        "localidade",
        "uf",
        "ibge",
        "gia",
        "ddd",
        "siafi"
    })
    public static class Address {
        @JsonProperty("cep")
        public String cep;
        @JsonProperty("logradouro")
        public String logradouro;
        @JsonProperty("complemento")
        public String complemento;
        @JsonProperty("bairro")
        public String bairro;
        @JsonProperty("localidade")
        public String localidade;
        @JsonProperty("uf")
        public String uf;
        @JsonProperty("ibge")
        public String ibge;
        @JsonProperty("gia")
        public String gia;
        @JsonProperty("ddd")
        public String ddd;
        @JsonProperty("siafi")
        public String siafi;
    }
}