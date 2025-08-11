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

}