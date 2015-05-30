package RideMate.services.impl;

import RideMate.domain.Chip;
import RideMate.repository.ChipRepository;
import RideMate.services.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/05/20.
 */
@Service
public class ChipServiceImpl implements ChipService {
    @Autowired
    ChipRepository repository;
    public List<Chip> getAllChips() {
        List<Chip> allChips = new ArrayList<Chip>();

        Iterable<Chip> chips = repository.findAll();
        for(Chip chip:chips){
            allChips.add(chip);
        }
        return allChips;
    }
}
