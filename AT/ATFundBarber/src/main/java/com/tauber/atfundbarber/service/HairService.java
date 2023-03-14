package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.Hair;
import java.util.List;

public interface HairService {

    Hair save(Hair hair);
    List<Hair> getAllHairs();

    void delete(Hair hair);
}
