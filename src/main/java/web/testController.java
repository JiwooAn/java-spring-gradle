package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TestService;

@Controller
public class testController {

    @ResponseBody // Controller에서는 객체가 아니라 view를 반환하기 때문에 ResponseBody를 사용해서 객체를 보내준다.
    @GetMapping("test")
    public String test(Model model) {
        String result = TestService.test();
        System.out.printf("result ==> %s", result);
        return result;
    }
    
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("test", "예오예");
        model.addAttribute("test2", "오예오");
        System.out.printf("model ==> %s", model);
        
        return "hello"; // templates의 hello.html 을 찾아감
    }

}
