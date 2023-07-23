package com.viettran.springbootfinalpractice.service.impl;

import com.viettran.springbootfinalpractice.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class HelloWorldServiceImpl implements HelloWorldService {
    private final MessageSource messageSource;

    public String helloWorldInternationalized() {
        // LocaleContextHolder is a helper class that provides Locale resolution from header
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
