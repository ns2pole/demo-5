package com.example.servingwebcontent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sample.framework.util.SampleErrorMessageMap;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException authenticationException)
            throws IOException, ServletException {

        String errorId = "";
        // ExceptionからエラーIDをセットする
        if(authenticationException instanceof BadCredentialsException){
            errorId = "おかしなエラー";
        }

        // ログイン画面にリダイレクトする
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/"
                + httpServletRequest.getParameter("identifier") + "/index?error=" + errorId);
    }
}