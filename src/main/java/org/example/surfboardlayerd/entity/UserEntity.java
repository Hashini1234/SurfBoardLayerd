package org.example.surfboardlayerd.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    private String id;
    private String name;
    private String email;
    private String role;
    private String password;
}
