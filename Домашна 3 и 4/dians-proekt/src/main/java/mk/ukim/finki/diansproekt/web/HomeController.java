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
                            @RequestParam(required = false) String type,
                            @RequestParam(required = false) String search,
                            Model model) {
        if (bankChoice != null && !bankChoice.equals("") && type != null && !type.equals("")) {
            if (this.amenityService.findByNameAndType(bankChoice, type).isPresent()) {
                model.addAttribute("bank", this.amenityService.findByNameAndType(bankChoice, type).get());
                model.addAttribute("bankName", this.amenityService.findByNameAndType(bankChoice, type).get().getName());
                model.addAttribute("lat", this.amenityService.findByNameAndType(bankChoice, type).get().getLatitude());
                model.addAttribute("lon", this.amenityService.findByNameAndType(bankChoice, type).get().getLongitude());
                model.addAttribute("type", this.amenityService.findByNameAndType(bankChoice, type).get().getType());
            } else {
                model.addAttribute("hasError", true);
                model.addAttribute("error", "Не постои банкомат од избраната банка во општина Карпош");
            }
        } else if (search != null && !search.equals("")) {
            model.addAttribute("chosen", this.amenityService.search(search));
            if (this.amenityService.search(search).isPresent()) {
                model.addAttribute("bank", this.amenityService.search(search).get());
                model.addAttribute("bankName", this.amenityService.search(search).get().getName());
                model.addAttribute("lat", this.amenityService.search(search).get().getLatitude());
                model.addAttribute("lon", this.amenityService.search(search).get().getLongitude());
            } else {
                model.addAttribute("hasError", true);
                model.addAttribute("error", "Не постои банкомат од избраната банка во општина Карпош!");
            }
        }
        return "main";
    }
}