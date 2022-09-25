package pl.milypol.magazinestatus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milypol.magazinestatus.entity.IncomingOrder;
import pl.milypol.magazinestatus.repository.IncomingOrderRepository;

@Controller
@RequestMapping("/incomings")
public class IncomingOrderController {
    private final IncomingOrderRepository incomingOrderRepository;

    public IncomingOrderController(IncomingOrderRepository incomingOrderRepository) {
        this.incomingOrderRepository = incomingOrderRepository;
    }


    @GetMapping
    public String IncomingOrder(Model model) {
        model.addAttribute("orders",incomingOrderRepository.findAll());
        model.addAttribute("newOrder", new IncomingOrder());
        return "incomingOrder";
    }
    @PostMapping
    public String addOrder(IncomingOrder order) {
        incomingOrderRepository.save(order);
        return "redirect:/incomings";
    }
    @DeleteMapping(value = "{id}")
    public String deleteIncomingOrder(@PathVariable Long id) {
        incomingOrderRepository.deleteById(id);
        return "redirect:/incomings";
    }

    @GetMapping("{id}")
    public String getIncomingOrder(@RequestParam Long id,Model model){
        model.addAttribute("order", incomingOrderRepository.findById(id).get());
        return "editIncomingOrder";
    }

    @PutMapping
    public String editIncomingOrder(IncomingOrder incomingOrder){
        incomingOrderRepository.save(incomingOrder);
        return "redirect:/incomings";
    }


}
