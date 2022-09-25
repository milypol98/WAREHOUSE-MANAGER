package pl.milypol.magazinestatus.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milypol.magazinestatus.entity.IncomingOrder;
import pl.milypol.magazinestatus.repository.IncomingOrderRepository;
import pl.milypol.magazinestatus.repository.UserRepository;
import pl.milypol.magazinestatus.seciurity.CurrentUser;

@Controller
@RequestMapping("/incomings")
public class IncomingOrderController {
    private final IncomingOrderRepository incomingOrderRepository;
    private final UserRepository userRepository;

    public IncomingOrderController(IncomingOrderRepository incomingOrderRepository, UserRepository userRepository) {
        this.incomingOrderRepository = incomingOrderRepository;
        this.userRepository = userRepository;
    }


    @GetMapping
    public String IncomingOrder(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("orders",incomingOrderRepository.findAllByUserId(customUser.getUser().getId()));
        model.addAttribute("newOrder", new IncomingOrder());
        return "incomingOrder";
    }
    @PostMapping
    public String addOrder(@AuthenticationPrincipal CurrentUser customUser,IncomingOrder order) {
        order.setUser(customUser.getUser());
        incomingOrderRepository.save(order);
        return "redirect:/incomings";
    }
    @DeleteMapping
    public String deleteIncomingOrder(@RequestParam Long id) {
        incomingOrderRepository.deleteById(id);
        return "redirect:/incomings";
    }

    @GetMapping("/edit")
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
