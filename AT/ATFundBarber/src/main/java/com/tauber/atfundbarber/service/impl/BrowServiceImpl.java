package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.repository.BrowRepository;
import com.tauber.atfundbarber.service.BrowService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrowServiceImpl implements BrowService {

    private final BrowRepository browRepository;

    @Override
    public Brow save(Brow brow) {
        return browRepository.save(brow);
    }

    @Override
    public List<Brow> getAllBrows() {
        return browRepository.findAll();
    }

    @Override
    public void delete(Brow brow) {
        browRepository.delete(brow);
    }
}
