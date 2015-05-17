package RideMate.repository;

import RideMate.App;
import RideMate.conf.factory.ChipFactory;
import RideMate.conf.factory.CyclerFactory;
import RideMate.domain.Chip;
import RideMate.domain.Cycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 2015/05/10.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ChipCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Cycler cycler;

    @Autowired
    private ChipRepository repository;

    @Test
    public void create() throws Exception {

        Cycler cycler = CyclerFactory.createCycler("jack", "bob", 23);

        Chip chip = ChipFactory.createChip(cycler);
        repository.save(chip);
        id=chip.getChipID();
        Assert.assertNotNull(chip);

    }

       @Test(dependsOnMethods = "create")
        public void read ()throws Exception {
            Chip chip = repository.findOne(id);
            Assert.assertNotNull(chip.getChipID());


        }

       /* @Test(dependsOnMethods = "read")
        public void update ()throws Exception {

        }*/

        @Test(dependsOnMethods = "read")
        public void delete ()throws Exception {
            Chip chip = repository.findOne(id);
            repository.delete(chip);
            Chip deletedChip = repository.findOne(id);
            Assert.assertNull(deletedChip);
            repository.save(chip);

        }
    }
