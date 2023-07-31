package com.ipg.merchantservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String username;
    private String email;
    private String merchantId;
    private String partnerId;
    private String photoUrl;
    private String realm;
    private String status;
    private String createdAt;
    private String updatedAt;

}
