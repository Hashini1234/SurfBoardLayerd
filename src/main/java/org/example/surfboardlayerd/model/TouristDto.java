package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
public class TouristDto {
    private String touristId;
    private String name;
    private String address;
    private String contactDetails;
    private String email;

}