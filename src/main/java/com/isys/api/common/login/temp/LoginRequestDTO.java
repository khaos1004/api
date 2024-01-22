package com.isys.api.common.login.temp;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDTO {
    private String name;
    private String password;
}
