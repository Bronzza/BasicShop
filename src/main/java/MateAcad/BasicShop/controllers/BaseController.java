package MateAcad.BasicShop.controllers;


import MateAcad.BasicShop.Entities.Product;
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

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BaseController {

    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "index";
    }

    @RequestMapping("/new")
    public String createNewProductForm(@Valid Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/update/{uuid}")
    public ModelAndView editStudentForm(@PathVariable(name = "uuid") String uuid) {
        ModelAndView modelAndView = new ModelAndView("update_product");
        Product product = productService.getProductByUUID(uuid).get();
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{uuid}")
    public String deleteStudent(@PathVariable(name = "uuid") String uuid) {
        productService.deleteByUUID(uuid);
        return "redirect:/";
    }

}
