package ru.whitebeef.pepeshop.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class ShopItem {
    private String id;
    private String iconFilePath;
    private String title;
    private String description;
    private int cost;
    private int discount;
    private String tag;
}

