package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Cuts;
import java.util.List;

public interface CutsService {

    List<Cuts> getAllCuts();

    List<Cuts> getAllCutsByIds(List<String> toList);
}
