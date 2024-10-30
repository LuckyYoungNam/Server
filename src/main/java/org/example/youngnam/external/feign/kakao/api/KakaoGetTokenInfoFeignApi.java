package org.example.youngnam.external.feign.kakao.api;

import org.example.youngnam.external.feign.kakao.dto.KakaoAccessTokenInfoRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "kako-feign", url = "${feign.kakao.get-token-info-url}")
public interface KakaoGetTokenInfoFeignApi {
    @GetMapping("/v1/user/access_token_info")
    KakaoAccessTokenInfoRes getKakaoSocialId(@RequestHeader(HttpHeaders.AUTHORIZATION) final String accessTokenWithTokenType);
}
