package com.dts.miniproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwTTokenResponse {
    private String access_token;
    private String refresh_token;
}
