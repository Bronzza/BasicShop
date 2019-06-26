package MateAcad.BasicShop.controllers;


import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.dto.ProducerDto;
import MateAcad.BasicShop.dto.ProductDto;
import MateAcad.BasicShop.services.ProducerService;
import MateAcad.BasicShop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BaseController {

    private ProductService productService;

    private ProducerService producerService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "index";
    }

    @RequestMapping("/new")
    public String createNewProductForm(@Valid Model model) {
        ProductDto product = new ProductDto();
        Set<ProducerDto> allUnuqueProducersDto = producerService.findAllUniqueProducersDto();
        model.addAttribute("product", product);
//        model.addAttribute("producers", allUniqueProducers);
        model.addAttribute("producers", allUnuqueProducersDto);
        return "product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product") ProductDto productDto) {
        productService.saveProduct(productDto);
        return "redirect:/";
    }

    @RequestMapping("/update/{uuid}")
    public ModelAndView editStudentForm(@PathVariable(name = "uuid") String uuid) {
        ModelAndView modelAndView = new ModelAndView("update_product");
        ProductDto productDto = productService.getDtoByUUID(uuid).get();
        Set<ProducerDto> allUniqueProducers = producerService.findAllUniqueProducersDto();
        modelAndView.addObject("producers", allUniqueProducers);
        modelAndView.addObject("product", productDto);
        return modelAndView;
    }

    @RequestMapping("/delete/{uuid}")
    public String deleteStudent(@PathVariable(name = "uuid") String uuid) {
        productService.deleteByUUID(uuid);
        return "redirect:/";
    }

}
