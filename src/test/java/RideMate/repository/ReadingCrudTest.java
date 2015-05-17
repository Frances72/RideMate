package RideMate.repository;

import RideMate.App;
import RideMate.domain.Chip;
import RideMate.domain.Cycler;
import RideMate.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by User on 2015/05/17.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ReadingCrudTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ReadingRepository repository;

    private Long id;
    private Chip chip;
    private Cycler cycler;
    private Reader reader;
    private Date readTime;
/*
* How do you code the tests for an Entity that is composed of other entities?
* I am unable to create concrete test variables when they are composed at runtime only.
*
*
* */
    @Test
    public void create() throws Exception{

      /* Reading reading = new Reading.Builder(chip).cycler(cycler).reader(reader).readTime(readTime).build();
        repository.save(reading);
        id = reading.getReadingId();
        Assert.assertNotNull(reader.getReaderId());   */
        System.out.println("This is inside the create for Reading test");
    }
   @Test(dependsOnMethods = "create")
    public void read ()throws Exception {   /*
        Reading reading = repository.findOne(id);
        Assert.assertNotNull(reading.getReadingId()); */
       System.out.println("This is inside the read for Reading test");
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
      /* Reading reading = repository.findOne(id);
        Reading reading = new Reader.Builder(chip). cycler(cycler).reader(reader).readTime(readTime).build();
        repository.save(reading);
        Reading updatedReading = repository.findOne(id);
        Assert.assertEquals();*/
        System.out.println("This is inside the update for Reading test");


    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        System.out.println("This is inside the delete for Reading test");
    }
}
