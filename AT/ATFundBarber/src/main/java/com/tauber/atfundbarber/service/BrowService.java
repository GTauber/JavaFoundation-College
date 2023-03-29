package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Brow;
import java.util.List;

public interface BrowService {

    Brow save(Brow brow);
    List<Brow> getAllBrows();

    void delete(Brow brow);

    Brow getById(String cut);
}
