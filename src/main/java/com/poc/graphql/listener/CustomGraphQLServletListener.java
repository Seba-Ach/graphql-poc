package com.poc.graphql.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomGraphQLServletListener implements GraphQLServletListener {

    private static Logger log = LoggerFactory.getLogger(CustomGraphQLServletListener.class);

    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        return new RequestCallback() {
            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                RequestCallback.super.onSuccess(request, response);
            }

            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
                RequestCallback.super.onError(request, response, throwable);
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                log.info("your request {} has finished executing", request.getRequestURL().toString());
            }
        };
    }
}
