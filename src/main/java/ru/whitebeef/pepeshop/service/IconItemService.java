package ru.whitebeef.pepeshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.whitebeef.pepeshop.entity.IconItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IconItemService {

    @Getter
    private final List<IconItem> iconItems = new ArrayList<>();

    @Autowired
    public IconItemService(ShopItemService shopItemService) {
        loadIcons(shopItemService);
    }

    private void loadIcons(ShopItemService shopItemService) {
        try {
            File file = ResourceUtils.getFile("config/icon_items.json");
            iconItems.clear();
            ObjectMapper mapper = new ObjectMapper();
            iconItems.addAll(Arrays.stream(mapper.readValue(file, IconItem[].class)).toList());
            shopItemService.registerShopItems(iconItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
