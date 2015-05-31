package RideMate.service;

import RideMate.App;
import RideMate.conf.factory.CyclerFactory;
import RideMate.domain.Cycler;
import RideMate.repository.CyclerRepository;
import RideMate.services.CyclerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by User on 2015/05/31.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CyclerServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CyclerRepository repository;
    @Autowired
    private CyclerService service;

    private Long id;
    private String first;
    private String last;
    private int age;

    @Test
    public void create() throws Exception {
        Cycler cycler = CyclerFactory.createCycler("Cyclerservice", "Test", 2);
        repository.save(cycler);
        Assert.assertNotNull(cycler);
    }

    @Test
    public void getAllCyclers() throws Exception{
        List<Cycler> allCyclers = service.getAllCyclers();
        Assert.assertTrue(allCyclers.size()>0);
    }

}
