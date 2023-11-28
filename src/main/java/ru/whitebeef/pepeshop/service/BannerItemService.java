package ru.whitebeef.pepeshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.whitebeef.pepeshop.entity.BannerItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BannerItemService {

    private static final String BANNER_ITEMS_PATH = "src/main/resources/static/config/banner_items.json";
    @Getter
    private final List<BannerItem> bannerItems = new ArrayList<>();

    @Autowired
    public BannerItemService(ShopItemService shopItemService) {
        loadIcons(shopItemService);
    }

    private void loadIcons(ShopItemService shopItemService) {
        try {
            bannerItems.clear();
            ObjectMapper mapper = new ObjectMapper();
            bannerItems.addAll(Arrays.stream(mapper.readValue(new File(BANNER_ITEMS_PATH), BannerItem[].class)).toList());
            shopItemService.registerShopItems(bannerItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
