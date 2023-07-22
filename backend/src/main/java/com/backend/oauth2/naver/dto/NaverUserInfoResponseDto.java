package com.backend.oauth2.naver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverUserInfoResponseDto {

    @JsonProperty("resultcode")
    private String resultCode;

    private String message;

    private Response response;

    @Getter @Setter
    public static class Response {

        private String email;

        private String nickname;

        @JsonProperty("profile_image")
        private String profileImage;

        private String mobile;
    }
}
