package ru.whitebeef.pepeshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.whitebeef.pepeshop.entity.IconItem;

public class IconItemServiceTests {

    @Test
    void pojoToJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        IconItem[] items = {
                new IconItem("autumn_leaf", "/img/icons/autumn_leaf.webp", "Осенний листочек", "Осень порой несет с собой грусть, так как многие деревья лишаются своих красочных листьев, создавая атмосферу ухода и увядания природы перед наступлением зимы.", 5000, 0, "NEW"),
                new IconItem("mulled_wine", "/img/icons/mulled_wine.webp", "Ароматный глинтвейн", "Глинтвейн — древний напиток с красным вином, специями и цитрусовыми, популярный зимой и на праздниках.", 5000, 0, "")
        };
        String jsonResult = mapper.writeValueAsString(items);

        IconItem[] anotherItems = mapper.readValue(jsonResult, IconItem[].class);
        Assertions.assertArrayEquals(items, anotherItems);
    }
}
