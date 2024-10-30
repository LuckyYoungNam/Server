package org.example.youngnam.external.feign.kakao;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.example.youngnam.external.feign.kakao.dto.KakaoAccessTokenInfoRes;
import org.example.youngnam.external.feign.kakao.dto.KakaoAccessTokenRes;
import org.example.youngnam.global.Constants;
import org.example.youngnam.global.exception.BadRequestException;
import org.example.youngnam.global.exception.ErrorCode;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KakaoFeignProvider {
    private final KakaoProperties kakaoProperties;
    private final KakaoFeignApi kakaoFeignApi;

    public String login(final String authorizationCode) {
        try {
            final String accessTokenWithBearer = getKakaoAccessToken(authorizationCode);
            return getSocialId(accessTokenWithBearer);
        } catch (FeignException e) {
            throw new BadRequestException(ErrorCode.BAD_KAKAO_REQUEST);
        }
    }

    //카카오 액세스 토큰 받아서 Bearer 붙여서 리턴
    private String getKakaoAccessToken(final String authorizationCode) {
        KakaoAccessTokenRes kakaoAccessTokenRes = kakaoFeignApi.getKakaoAccessToken(
                Constants.AUTH_CODE,
                kakaoProperties.getRestApiKey(),
                kakaoProperties.getRedirect(),
                authorizationCode
        );
        return Constants.BEARER + kakaoAccessTokenRes.accessToken();
    }

    // 카카오 액세스 토큰으로 카카오의 userID 가져오기
    private String getSocialId(final String accessToken) {
        KakaoAccessTokenInfoRes kakaoAccessTokenInfoRes = kakaoFeignApi.getKakaoPlatformUserId(accessToken);
        return String.valueOf(kakaoAccessTokenInfoRes.id());
    }
}
