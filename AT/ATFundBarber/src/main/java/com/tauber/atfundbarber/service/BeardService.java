package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Beard;
import java.util.List;

public interface BeardService {

    Beard save(Beard beard);

    List<Beard> getAllBeards();

}