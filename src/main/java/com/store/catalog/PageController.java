package com.store.catalog;

import com.store.catalog.domain.Product;
import com.store.catalog.repository.CatalogRepository;
import com.store.catalog.repository.HotSaleRepository;
import com.store.catalog.repository.ProductRepository;
import javafx.scene.control.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * Created by yzq on 2018/7/15.
 */
@Controller
@RequestMapping("/")
public class PageController {
    @Resource
    ProductRepository productRepository;
    @Resource
    HotSaleRepository hotSaleRepository;
    @Resource
    CatalogRepository catalogRepository;

    @GetMapping()
    public String index(Model mode) {
        Pageable pageable = PageRequest.of(0,4, Sort.Direction.DESC,"ordernum");
        mode.addAttribute("list", hotSaleRepository.findHostProduct("category","1",pageable).getContent());
        mode.addAttribute("hotSale", hotSaleRepository.findHostProduct("homePage","homePage",PageRequest.of(0,10, Sort.Direction.DESC,"ordernum")).getContent());
        mode.addAttribute("recommend", hotSaleRepository.findHostProduct("recommend","recommend",PageRequest.of(0,2, Sort.Direction.DESC,"ordernum")).getContent());
        mode.addAttribute("nav","home");
        return "index";
    }
    @GetMapping("/product")
    public String product(Model mode, HttpServletRequest request) {
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"lastModified");
        Long category = StringUtils.isEmpty(request.getParameter("category"))?1:Long.valueOf(request.getParameter("category"));

        mode.addAttribute("tableList", productRepository.findByCatalogId(category,pageable).getContent());
        mode.addAttribute("label",catalogRepository.findAll());

        mode.addAttribute("nav","product");
        return "product";
    }
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model mode) {
        Product product = productRepository.getOne(id);
        mode.addAttribute("p", product);
        Page<Product> page = productRepository.findByCatalogIdAndBrandId(product.getCatalog().getId(),product.getBrand().getId(),PageRequest.of(0,10, Sort.Direction.DESC,"ordernum"));
        mode.addAttribute("p",product);
        mode.addAttribute("ps",page.getContent());
        return "productOne";
    }
    @GetMapping("/order")
    public String order(Model mode) {

        mode.addAttribute("nav","order");
        return "order";
    }
    @GetMapping("/comment")
    public String comment(Model mode) {

        mode.addAttribute("nav","comment");
        return "comment";
    }
    @GetMapping("/paper")
    public String about(Model mode) {
        mode.addAttribute("nav","paper");
        return "paper";
    }
}
