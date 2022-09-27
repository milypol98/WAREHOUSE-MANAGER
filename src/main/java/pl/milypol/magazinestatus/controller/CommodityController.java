package pl.milypol.magazinestatus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milypol.magazinestatus.entity.Commodity;
import pl.milypol.magazinestatus.repository.CommodityRepository;
import pl.milypol.magazinestatus.repository.IncomingOrderRepository;
import pl.milypol.magazinestatus.repository.TypeRepository;

@Controller
@RequestMapping(value = "/commodity")
public class CommodityController {
    private final CommodityRepository commodityRepository;
    private final IncomingOrderRepository incomingOrderRepository;
    private final TypeRepository typeRepository;


    public CommodityController(CommodityRepository commodityRepository, IncomingOrderRepository incomingOrderRepository, TypeRepository typeRepository) {
        this.commodityRepository = commodityRepository;
        this.incomingOrderRepository = incomingOrderRepository;
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public String getCommodity(@RequestParam Long id, Model model) {
        model.addAttribute("commodity", new Commodity());
        model.addAttribute("incomingOrderId",incomingOrderRepository.findById(id).get());
        model.addAttribute("commodities", commodityRepository.findAllByIncomingOrderId(id));
        model.addAttribute("types", typeRepository.findAllByUserId(id));
        return "commodity";
    }
    @PostMapping
    public String addCommodity( Commodity commodity){
        commodityRepository.save(commodity);
        return "redirect:/commodity";
    }


    @DeleteMapping
    public String deleteCommodity(@RequestParam Long id) {
        commodityRepository.deleteById(id);
        return "commodity";
    }

}
