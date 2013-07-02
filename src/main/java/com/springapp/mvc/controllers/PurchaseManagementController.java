package com.springapp.mvc.controllers;

import com.springapp.mvc.models.Product;
import com.springapp.mvc.models.Vendor;
import com.springapp.mvc.services.VendorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseManagementController {
    @Autowired
    VendorService vendorService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllVendors() {
        ModelAndView modelAndView = new ModelAndView("newOrder");
        List<Vendor> vendorList = vendorService.getAllVendors();
        modelAndView.addObject("VENDORS", vendorList);
        return modelAndView;
    }

    @RequestMapping(value = "/newOrder/{vendorId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ModelAndView getAllProductsByVendorId(@PathVariable("vendorId") int vendorId) {
        ModelAndView modelAndView = new ModelAndView("newOrder");
        List<Product> productList = vendorService.getAllProductsByVendorId(vendorId);
        modelAndView.addObject("PRODUCTS", productList);
        return modelAndView;
    }
}
