package com.barosanu.view;

import com.barosanu.EmailManager;

/**
 * Created by Arek on 02.04.2020.
 */
public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow(){
        System.out.println("show login window");
    }
}
