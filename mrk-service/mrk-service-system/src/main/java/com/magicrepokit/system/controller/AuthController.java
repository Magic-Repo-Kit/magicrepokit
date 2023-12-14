package com.magicrepokit.system.controller;

import com.magicrepokit.common.api.R;
import com.magicrepokit.system.dto.auth.AuthLoginDTO;
import com.magicrepokit.system.dto.auth.AuthSocialLoginDTO;
import com.magicrepokit.system.vo.auth.AuthTokenVO;
import com.magicrepokit.system.service.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 登录认证接口
 *
 * @author AuroraPixel
 * @github https://github.com/AuroraPixel
 */
@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private IAuthService authService;


    /**
     * 用户登录接口
     *
     * @param authLoginDTO 登录实体类
     * @return 令牌信息
     */
    @PostMapping("/login")
    public R<AuthTokenVO> Login(@RequestBody @Valid AuthLoginDTO authLoginDTO){
        return R.data(authService.login(authLoginDTO));
    }

    /**
     * 刷新token
     *
     * @param refreshToken
     * @return 令牌信息
     */
    @PostMapping("/refresh-token")
    public R<AuthTokenVO> refreshToken(@RequestParam("refreshToken") String refreshToken){
        return R.data(authService.refreshToken(refreshToken));
    }


    /**
     * 获得三方登录跳转地址
     *
     * @param type 三方平台类型
     * @param redirectUri 重定向地址
     * @return 三方请求地址
     */
    @GetMapping("/social-login-redirect")
    public R<String> socialLoginRedirect(@RequestParam("type") Integer type,
                                         @RequestParam("redirectUri") String redirectUri){
        return R.data(authService.socialLoginRedirect(type,redirectUri));
    }

    /**
     * 三方授权码登录
     *
     * @param authSocialLoginDTO 三方授权登录信息
     * @return 令牌信息
     */
    @PostMapping("/social-login")
    public R<AuthTokenVO> socialLogin(@RequestBody AuthSocialLoginDTO authSocialLoginDTO){
        return R.data(authService.socialLogin(authSocialLoginDTO));
    }

}

