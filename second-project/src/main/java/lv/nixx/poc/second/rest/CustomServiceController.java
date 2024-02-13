package lv.nixx.poc.second.rest;

import lv.nixx.poc.second.service.CustomService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomServiceController {

    private final CustomService firstService;
    private final CustomService secondService;

    public CustomServiceController(
            @Qualifier("firstService") CustomService firstService,
            @Qualifier("secondService") CustomService secondService
    ) {
        this.firstService = firstService;
        this.secondService = secondService;
    }

    @GetMapping("/firstService/{param}")
    public String processFirst(@PathVariable String param) {
        return firstService.process(param);
    }

    @GetMapping("/secondService/{param}")
    public String processSecond(@PathVariable String param) {
        return secondService.process(param);
    }

}
