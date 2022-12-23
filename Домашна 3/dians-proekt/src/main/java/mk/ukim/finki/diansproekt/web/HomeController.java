package mk.ukim.finki.diansproekt.web;

import mk.ukim.finki.diansproekt.service.AmenityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final AmenityService amenityService;

    public HomeController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("banks", this.amenityService.findByType("Bank"));
        model.addAttribute("atms", this.amenityService.findByType("ATM"));
        return "main";
    }

    @PostMapping("/filter")
    public String getFilter(@RequestParam String bankChoice,
                            @RequestParam String type, Model model) {

        if (bankChoice != null && !bankChoice.equals("") && type != null && !type.equals("")) {
            if (type.equals("All")) {
                model.addAttribute("chosen", this.amenityService.findByName(bankChoice));
            } else {
                model.addAttribute("chosen", this.amenityService.findByNameAndType(bankChoice, type));
            }
        }

        System.out.println(bankChoice);
        System.out.println(type);

        return "redirect:/home";
    }
}