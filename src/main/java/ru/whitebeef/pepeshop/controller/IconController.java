package ru.whitebeef.pepeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.whitebeef.pepeshop.service.IconItemService;

@Controller
public class IconController {
    private final IconItemService iconItemService;

    @Autowired
    public IconController(IconItemService iconItemService) {
        this.iconItemService = iconItemService;
    }

    @GetMapping("/icons")
    public String getIcons(Model model) {
        model.addAttribute("icons", iconItemService.getIconItems());
        return "icons";
    }
}
