package org.example.surfboardlayerd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String id;
    private String name;
    private String email;
    private String role;
    private String password;

}
