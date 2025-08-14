package org.example.surfboardlayerd.entity;



import lombok.*;
import org.example.surfboardlayerd.view.tdm.GuideTM;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GuideEntity  {
    private String guide_id;
    private String name;
    private String contact_Details;
    private String experience_Level;
    private Double pay_for;

}
