package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class BeachLocationDto {
    private String beachId;
    private String name;
    private String peakSeason;
    private String month;

}