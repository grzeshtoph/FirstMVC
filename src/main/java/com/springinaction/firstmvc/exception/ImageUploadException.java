package com.springinaction.firstmvc.exception;

/**
 * Image uploading exception to be handled in the WWW controllers.
 */
public class ImageUploadException extends Exception {
    public ImageUploadException(String message) {
        super(message);
    }
}
