package com.epoch.ecommercebackend2.api.model;

/**
 * The response object sent from login request.
 */
public class LoginResponse {
    /** The JWT token to be used for authentication. */
    private String jwt;
    private boolean success;
    private String failureReason;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
