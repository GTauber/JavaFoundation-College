package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.repository.BeardRepository;
import com.tauber.atfundbarber.service.BeardService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeardServiceImpl implements BeardService {

    private final BeardRepository beardRepository;

    @Override
    public Beard save(Beard beard) {
        return beardRepository.save(beard);
    }

    @Override
    public List<Beard> getAllBeards() {
        return beardRepository.findAll();
    }
}
