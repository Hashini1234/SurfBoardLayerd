package org.example.surfboardlayerd.model;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class BillDto {
    private String billId;
    private BigDecimal amount;
    private String touristId;

   }