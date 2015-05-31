package RideMate.api;

import RideMate.domain.Cycler;
import RideMate.model.CyclerResource;
import RideMate.services.CyclerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/05/31.
 */
@RestController
@RequestMapping("/cyclerpage/**")
public class CyclerPage {
    @Autowired
    private CyclerService cyclerService;
    @RequestMapping(value="cyclerdisplay", method = RequestMethod.GET)

    public List<CyclerResource> getCyclers(){
        List<CyclerResource> hateoas = new ArrayList<>();
        List<Cycler> cyclers = cyclerService.getAllCyclers();
        for(Cycler cycler: cyclers){
            CyclerResource res = new CyclerResource
                                .Builder(cycler.getCyclerID())
                                .first(cycler.getFirst())
                                .last(cycler.getLast())
                                .age(cycler.getAge())
                                .build();
            Link cyclist = new Link("http://localhost:8183/cycler/" + res.getResId().toString()).withRel("cycler1");
            res.add(cyclist);
            hateoas.add(res);
        }
        return hateoas;
    }

}
