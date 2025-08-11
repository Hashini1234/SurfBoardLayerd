package org.example.surfboardlayerd.model;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class SessionDto {
    private String sessionId;
    private Date date;
    private Time time;
    private String duration;
    private String touristId;
    private String beachId;
    private String guideId;
    private String status;
    private String paymentId;
    private String method;
    private String amount;
    private String surfboardId;

    public SessionDto(String sessionId, Date date, Time time, String duration, String touristId, String beachId, String guideId, String status) {
        this.sessionId = sessionId;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.touristId = touristId;
        this.beachId = beachId;
        this.guideId = guideId;
        this.status = status;
    }
}