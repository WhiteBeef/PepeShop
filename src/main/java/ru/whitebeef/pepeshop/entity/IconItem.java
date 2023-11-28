package ru.whitebeef.pepeshop.entity;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IconItem extends ShopItem {


    public IconItem(String id, String iconFilePath, String title, String description, int cost, int discount, String tag) {
        super(id, iconFilePath, title, description, cost, discount, tag);
    }
}
