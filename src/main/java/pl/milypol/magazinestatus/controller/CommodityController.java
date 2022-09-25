package pl.milypol.magazinestatus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milypol.magazinestatus.repository.CommodityRepository;

@Controller
@RequestMapping(value = "/commoodity")
public class CommodityController {
    private final CommodityRepository commodityRepository;


    public CommodityController(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @GetMapping
    public String getCommodity(@RequestParam Long id, Model model) {
        model.addAttribute("commodities", commodityRepository.findAllByIncomingOrderId(id));
        return "commodity";
    }
    @DeleteMapping(value = "/{id}")
    public String deleteCommodity(@PathVariable("id") Long id) {
        commodityRepository.deleteById(id);
        return "commodity";
    }

}
