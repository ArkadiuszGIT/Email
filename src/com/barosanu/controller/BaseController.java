package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.view.ViewFactory;

/**
 * Created by Arek on 02.04.2020.
 */
public abstract class BaseController {

    protected EmailManager emailManager;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
