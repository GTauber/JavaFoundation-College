package com.tauber.atfundbarber.clients;

import com.tauber.atfundbarber.model.entity.User.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viaCepClient")
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/json")
    Address getAddress(@PathVariable String cep);

}
