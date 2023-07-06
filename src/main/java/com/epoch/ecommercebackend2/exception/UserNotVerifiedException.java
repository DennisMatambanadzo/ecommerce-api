package com.epoch.ecommercebackend2.exception;

/**
 * Exception to highlight a user does not have a verified email address.
 */
public class UserNotVerifiedException extends Exception{

    /** Did we send a new email? */
    private boolean newEmailSent;

    public UserNotVerifiedException(boolean newEmailSent) {
        this.newEmailSent = newEmailSent;
    }

    /**
     * Was a new email sent?
     * @return True if it was, false otherwise.
     */
    public boolean isNewEmailSent() {
        return newEmailSent;
    }
}
