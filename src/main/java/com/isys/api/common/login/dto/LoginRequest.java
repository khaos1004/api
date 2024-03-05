package com.isys.api.common.login.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
    private String id;
    private String password;
}
