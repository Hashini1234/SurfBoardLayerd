package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class SurfBoardDto {
    private String surfboardId;
    private String brand;
    private String conditions;
    private String status; // Available, Not Available, Under Maintenance

}