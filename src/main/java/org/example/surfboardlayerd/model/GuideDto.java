package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@AllArgsConstructor
@Setter

public class GuideDto {
    private String guide_id;
    private String name;
    private String contact_Details;
    private String experience_Level;
    private Double pay_for;

}