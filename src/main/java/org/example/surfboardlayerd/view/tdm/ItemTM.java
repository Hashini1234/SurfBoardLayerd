package org.example.surfboardlayerd.view.tdm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ItemTM {
    private String itemId;
    private String name;
    private int qtyOnHand;
    private double unitPrice;
}
