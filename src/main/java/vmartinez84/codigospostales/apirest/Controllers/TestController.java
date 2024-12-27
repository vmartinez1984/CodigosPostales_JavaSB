package vmartinez84.codigospostales.apirest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Test")
public class TestController {

    @GetMapping("HolaMundo")
    public String getMethodName() {
        return "Hola mundo";
    }
}
