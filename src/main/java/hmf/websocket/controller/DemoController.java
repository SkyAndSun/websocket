package hmf.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo/")
public class DemoController {

    public DemoController() {
        System.out.println("this is DemoController.....");
    }

    @RequestMapping("demoPage")
    public String showDemo(){
        System.out.println("demoPage.html.....");
        return "demo";
    }
}
