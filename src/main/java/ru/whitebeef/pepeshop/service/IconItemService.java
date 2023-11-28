package ru.whitebeef.pepeshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    private static final String ICON_ITEMS_PATH = "src/main/resources/static/config/icon_items.json";

    @Autowired
    public IconItemService(ShopItemService shopItemService) {
        loadIcons(shopItemService);
    }

    private void loadIcons(ShopItemService shopItemService) {
        try {
            iconItems.clear();
            ObjectMapper mapper = new ObjectMapper();
            iconItems.addAll(Arrays.stream(mapper.readValue(new File(ICON_ITEMS_PATH), IconItem[].class)).toList());
            shopItemService.registerShopItems(iconItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
