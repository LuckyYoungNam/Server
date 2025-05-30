package org.example.youngnam.external.feign.kakao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("feign.kakao")
@Component
public class KakaoProperties {
    private String redirect;
    private String restApiKey;
}
