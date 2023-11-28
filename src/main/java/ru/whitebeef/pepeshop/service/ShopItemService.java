package ru.whitebeef.pepeshop.service;

import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.whitebeef.pepeshop.entity.ShopItem;

import java.util.Collection;
import java.util.HashMap;

@Service
@NoArgsConstructor
public class ShopItemService {

    private final HashMap<String, ShopItem> shopItems = new HashMap<>();

    public void registerShopItems(Collection<? extends ShopItem> shopItems) {
        for (ShopItem shopItem : shopItems) {
            this.shopItems.put(shopItem.getId(), shopItem);
        }
    }

    @Nullable
    public ShopItem getShopItem(String key) {
        return shopItems.get(key);
    }

    public HashMap<String, ShopItem> getShopItems() {
        return shopItems;
    }
}
