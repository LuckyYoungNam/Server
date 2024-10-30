package org.example.youngnam.external.feign.kakao.api;

import org.example.youngnam.external.feign.kakao.dto.KakaoAccessTokenRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.kakao.name}", url = "${feign.kakao.get-token-url}")
public interface KakaoGetTokenFeignApi {

    @PostMapping(value = "/oauth/token")
    KakaoAccessTokenRes getKakaoAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );
}
