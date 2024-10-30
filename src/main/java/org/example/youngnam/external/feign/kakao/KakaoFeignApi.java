package org.example.youngnam.external.feign.kakao;

import org.example.youngnam.external.feign.kakao.dto.KakaoAccessTokenInfoRes;
import org.example.youngnam.external.feign.kakao.dto.KakaoAccessTokenRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.kakao.name}", url = "${feign.kakao.url}")
public interface KakaoFeignApi {

    @PostMapping(value = "/oauth/token")
    KakaoAccessTokenRes getKakaoAccessToken(
            @RequestParam("grant_type") final String grantType,
            @RequestParam("client_id") final String clientId,
            @RequestParam("redirect_uri") final String redirectUri,
            @RequestParam("code") final String code
    );

    @GetMapping("/v1/user/access_token_info")
    KakaoAccessTokenInfoRes getKakaoPlatformUserId(@RequestHeader(HttpHeaders.AUTHORIZATION) final String accessTokenWithTokenType);
}
