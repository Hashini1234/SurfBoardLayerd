package org.example.surfboardlayerd.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ItemEntity {
    private String itemId;
    private String name;
    private int qtyOnHand;
    private double unitPrice;
}
