package MateAcad.BasicShop.controllers;

import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.dto.ProducerDto;
import MateAcad.BasicShop.services.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class ProducerController {

    private ProducerService producerService;

    @GetMapping("/producer")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        ProducerDto producerDto = new ProducerDto();
        modelAndView.addObject("producerDto", producerDto)
                .setViewName("producer");
        return modelAndView;
    }

    @RequestMapping(value = "/saveproducer", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("producerDto") ProducerDto producerdto) {
        producerService.saveProducer(producerdto);
        return "redirect:/";
    }
}
