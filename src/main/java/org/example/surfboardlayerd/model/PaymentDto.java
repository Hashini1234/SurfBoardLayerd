package org.example.surfboardlayerd.model;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class PaymentDto {
    private String paymentId;
    private BigDecimal amount;
    private String sessionId;
    private String paymentMethod;
    private Date paymentDate;



}