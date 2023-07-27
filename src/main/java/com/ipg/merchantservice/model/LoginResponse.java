package com.ipg.merchantservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    public String id;
    public String name;
    public String email;
    public String realm;
    public String token;
    final public String type = "Bearer";
}
