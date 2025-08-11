package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@Setter
@AllArgsConstructor
@Getter
@ToString
public class ItemDto {
    private String itemId;
    private String name;
    private String type;
    private String conditions;
    private String availabilityStatus;

    public ItemDto(String text, String text1, int i, double v) {
        this.itemId = text;
        this.name = text1;
        this.type = String.valueOf(i);
        this.conditions = String.valueOf(v);
    }

    public char[] getQtyOnHand() {
    }
}