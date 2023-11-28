package ru.whitebeef.pepeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.whitebeef.pepeshop.service.BannerItemService;

@Controller
public class BannerController {
    private final BannerItemService bannerItemService;

    @Autowired
    public BannerController(BannerItemService bannerItemService) {
        this.bannerItemService = bannerItemService;
    }

    @GetMapping("/banners")
    public String getBanners(Model model) {
        model.addAttribute("banners", bannerItemService.getBannerItems());
        return "banner_colors";
    }
}
