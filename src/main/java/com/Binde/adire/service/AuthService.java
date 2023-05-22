package com.Binde.adire.service;

import com.Binde.adire.dto.response.MessageResponse;
import com.Binde.adire.dto.request.ForgotPasswordDto;
import com.Binde.adire.dto.request.ResetPasswordRequest;

public interface AuthService {
    MessageResponse resetUserSecurityDetails(ResetPasswordRequest resetPasswordRequest);

    String passwordRequest(ForgotPasswordDto forgotPasswordDto);
}
