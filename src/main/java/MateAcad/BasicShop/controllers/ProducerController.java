package MateAcad.BasicShop.controllers;

import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.Entities.User;
import MateAcad.BasicShop.enums.Role;
import MateAcad.BasicShop.services.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {

    private ProducerService producerService;

    @GetMapping("/producer")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        Producer producer = new Producer();
        modelAndView.addObject("producer", producer)
                .setViewName("producer");
        return modelAndView;
    }

    @RequestMapping(value = "/saveproducer", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("producer") Producer producer) {
        producerService.saveProducer(producer);
        return "redirect:/";
    }
}
