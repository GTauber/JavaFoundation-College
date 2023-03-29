package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.repository.HairRepository;
import com.tauber.atfundbarber.service.HairService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HairServiceImpl implements HairService {

    private final HairRepository hairRepository;

    @Override
    public Hair save(Hair hair) {
        return hairRepository.save(hair);
    }
    @Override
    public List<Hair> getAllHairs() {
        return hairRepository.findAll();
    }
    @Override
    public void delete(Hair hair) {
        hairRepository.delete(hair);
    }

    @Override
    public Hair getById(String cut) {
        return hairRepository.findById(UUID.fromString(cut)).orElse(null);
    }
}
