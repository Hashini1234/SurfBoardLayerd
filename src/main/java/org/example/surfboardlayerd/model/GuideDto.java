package org.example.surfboardlayerd.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GuideDto {
    private String guideId;
    private String name;
    private String contactDetails;
    private String experienceLevel;
    private Double payFor;
    private String status;

}
