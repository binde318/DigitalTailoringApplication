package com.Binde.adire.service;


import com.Binde.adire.entity.Designer;

public interface EmailService {

     void sendForgotPasswordEmail(Designer user, String otp) throws Exception;

    //FOR account creation
    void sendAccountCreationNotification(String firstname, String lastname, String email);
}
