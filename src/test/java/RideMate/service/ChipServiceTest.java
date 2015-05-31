package RideMate.service;


import RideMate.App;
import RideMate.conf.factory.ChipFactory;
import RideMate.conf.factory.CyclerFactory;
import RideMate.domain.Chip;
import RideMate.domain.Cycler;
import RideMate.repository.ChipRepository;
import RideMate.services.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by User on 2015/05/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ChipServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ChipService service;
    private Long id;

    @Autowired
    private ChipRepository repository;

    @BeforeMethod
    public void setUp()throws Exception{

    }
   @Test
    public void create() throws Exception {

        Cycler cycler = CyclerFactory.createCycler("Dan", "Brown", 55);

        Chip chip = ChipFactory.createChip(cycler);
        repository.save(chip);
        id=chip.getChipID();
        Assert.assertNotNull(chip);

    }
  @Test
    public void getAllChips() throws Exception{
      List<Chip> allChips = service.getAllChips();
      Assert.assertTrue(allChips.size() >0);
  }
}
