package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨.
class SecurityConfig {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        return http // stateless한 rest api를 개발할 것이므로 csrf 공격에 대한 옵션은 꺼둔다.
            .csrf { obj: CsrfConfigurer<HttpSecurity> -> obj.disable() } // 특정 URL에 대한 권한 설정.
            .authorizeHttpRequests(Customizer { authorizeRequests ->
                authorizeRequests.requestMatchers("/user/**").authenticated()
                authorizeRequests.requestMatchers("/manager/**") // ROLE_은 붙이면 안 된다. hasAnyRole()을 사용할 때 자동으로 ROLE_이 붙기 때문이다.
                    .hasAnyRole("ADMIN", "MANAGER")

                authorizeRequests.requestMatchers("/admin/**") // ROLE_은 붙이면 안 된다. hasRole()을 사용할 때 자동으로 ROLE_이 붙기 때문이다.
                    .hasRole("ADMIN")
                authorizeRequests.anyRequest().permitAll()
            })

            .formLogin { formLogin: FormLoginConfigurer<HttpSecurity?> ->
                /* 권한이 필요한 요청은 해당 url로 리다이렉트 */
                formLogin.loginPage("/login")
            }

            .build()
    }
}