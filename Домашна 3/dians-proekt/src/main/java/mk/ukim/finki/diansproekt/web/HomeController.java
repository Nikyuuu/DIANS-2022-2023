package mk.ukim.finki.diansproekt.web;

import mk.ukim.finki.diansproekt.service.AmenityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class HomeController {
    private final AmenityService amenityService;

    public HomeController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    @GetMapping()
    public String getFilter(@RequestParam(required = false) String bankChoice,
                            @RequestParam(required = false) String type, Model model) {
        if(bankChoice != null && !bankChoice.equals("") && type != null && !type.equals("")) {
            if (type.equals("All")) {
                model.addAttribute("chosen", this.amenityService.findByName(bankChoice));
                model.addAttribute("bank", this.amenityService.findByName(bankChoice).get());
                model.addAttribute("bankName", this.amenityService.findByName(bankChoice).get().getName());
                model.addAttribute("lat", this.amenityService.findByName(bankChoice).get().getLatitude());
                model.addAttribute("lon", this.amenityService.findByName(bankChoice).get().getLongitude());

                System.out.println("From database - name: " + this.amenityService.findByName(bankChoice).get().getName());
                System.out.println("From database - latitude: " + this.amenityService.findByName(bankChoice).get().getLatitude());
                System.out.println("From database - longitude: " + this.amenityService.findByName(bankChoice).get().getLongitude());
            } else {
                model.addAttribute("chosen", this.amenityService.findByNameAndType(bankChoice, type));
                model.addAttribute("bank", this.amenityService.findByNameAndType(bankChoice, type).get());
                model.addAttribute("bankName", this.amenityService.findByNameAndType(bankChoice, type).get().getName());
                model.addAttribute("lat", this.amenityService.findByNameAndType(bankChoice, type).get().getLatitude());
                model.addAttribute("lon", this.amenityService.findByNameAndType(bankChoice, type).get().getLongitude());
                model.addAttribute("type", this.amenityService.findByNameAndType(bankChoice, type).get().getType());

                System.out.println("From database - type: " + this.amenityService.findByNameAndType(bankChoice, type).get().getType());
                System.out.println("From database - name: " + this.amenityService.findByNameAndType(bankChoice, type).get().getName());
                System.out.println("From database - latitude: " + this.amenityService.findByNameAndType(bankChoice, type).get().getLatitude());
                System.out.println("From database - longitude: " + this.amenityService.findByNameAndType(bankChoice, type).get().getLongitude());
            }
            System.out.println("User choice - bank: " + bankChoice);
            System.out.println("User choice - type: " + type);
        }

        return "main";
    }
}