package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class TransportDto {
    private String transportId;
    private String location;
    private String cost;
    private String touristId;
    private String vehicleType;

}