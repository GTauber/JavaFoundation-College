package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.Cuts;
import com.tauber.atfundbarber.service.CutsService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CutsServiceImpl implements CutsService {

    private final HairServiceImpl hairService;
    private final BeardServiceImpl beardService;
    private final BrowServiceImpl browService;

    @Override
    public List<Cuts> getAllCuts() {
        var cuts = new ArrayList<Cuts>();
        cuts.addAll(hairService.getAllHairs());
        cuts.addAll(beardService.getAllBeards());
        cuts.addAll(browService.getAllBrows());
        return cuts;
    }

    @Override
    public List<Cuts> getAllCutsByIds(List<String> toList) {
        var cuts = new ArrayList<Cuts>();
        toList.forEach(cut -> {
            var hair = hairService.getById(cut);
            var beard = beardService.getById(cut);
            var brow = browService.getById(cut);
            if (hair != null) cuts.add(hair);
            else if (beard != null) cuts.add(beard);
            else if (brow != null) cuts.add(brow);
        });

        return cuts;
    }
}
