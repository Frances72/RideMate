package RideMate.services.impl;

import RideMate.domain.Cycler;
import RideMate.repository.CyclerRepository;
import RideMate.services.CyclerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/05/20.
 */
@Service
public class CyclerServiceImpl implements CyclerService {

    @Autowired
    CyclerRepository repository;
    public List<Cycler> getAllCyclers() {
        List<Cycler> allCyclers = new ArrayList<>();

        Iterable<Cycler> cyclers = repository.findAll();
        for(Cycler cycler: cyclers){
            allCyclers.add(cycler);
        }
        return allCyclers;
    }

    public void createCycler(Cycler Entity){
        repository.save(Entity);

    }

    public void  updateCycler(Cycler Entity){
        repository.save(Entity);
    }

    public Cycler findCycler(Long Id){
        return repository.findOne(Id);
    }

    public void deleteCycler(Long Id){
        repository.delete(Id);
    }

    public void deleteCycler(Cycler Entity){
        repository.delete(Entity);
    }
}
