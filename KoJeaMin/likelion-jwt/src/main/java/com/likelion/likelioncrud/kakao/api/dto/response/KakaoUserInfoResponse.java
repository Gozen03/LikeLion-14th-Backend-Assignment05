package com.likelion.likelioncrud.kakao.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KakaoUserInfoResponse(

        Long id,

        @JsonProperty("properties")
        Properties properties,

        @JsonProperty("kakao_account")
        KakaoAccount kakaoAccount
) {

    public record Properties(
            String nickname
    ) {
    }

    public record KakaoAccount(
            String email
    ) {
    }

    public String getNickname() {
        if (properties == null || properties.nickname() == null) {
            return "카카오사용자";
        }

        return properties.nickname();
    }

    public String getEmail() {

        // TODO 카카오 동의항목에서 이메일 권한을 설정한 뒤, kakaoAccount.email() 반환
        if (kakaoAccount == null || kakaoAccount.email() == null) { // getNickname() 따라하기
            return "이메일미동의@kakao.com";  // 이메일 없을 때 반환값
        }

        return kakaoAccount.email();
    }
}
