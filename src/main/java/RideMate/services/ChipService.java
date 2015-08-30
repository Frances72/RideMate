package RideMate.services;

import RideMate.domain.Chip;

import java.util.List;

/**
 * Created by User on 2015/05/10.
 */

public interface ChipService {
    List<Chip> getAllChips();
    void createChip(Chip Entity);
    void  updateChip(Chip Entity);
    Chip findChip(Long Id);
    void deleteChip(Long Id);
    void deleteChip(Chip Entity);
}
