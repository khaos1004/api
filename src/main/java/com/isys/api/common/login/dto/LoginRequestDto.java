package com.isys.api.common.login.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequestDto {
    private String id;
    private String password;
}
