package API;

import dao.Random;
import dao.person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class randomapi {

    private Random random = new Random();

    @RequestMapping("/random")
    public List<person> getRandom() {
        return random.ran();
    }


}
