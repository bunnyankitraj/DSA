package org.example;

public class TokenCleaner {
    public static void main(String[] args) {
        String token = "Bearer ��\u0000\u0005t\u0000�eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6OTUsInVzZXJuYW1lIjoidHJpcF9wbGFubmVyIiwiZXhwIjoxNzM5NzA4MjY2fQ.IrBlC5wt2Edh79ED5X_AVcmcNp4r8Wa8g1s9jTYqyRQ";
        String cleanedToken = cleanInvalidCharacters(token);
        System.out.println(cleanedToken);
    }

    public static String cleanInvalidCharacters(String input) {
        // Remove any characters that are not valid for base64 URL-safe encoding
        // Base64 characters include A-Z, a-z, 0-9, -, _, . and any padding with =
        // Also handle any leading non-printable ASCII control characters
        return input.replaceAll("[^A-Za-z0-9-_=., ]", "");
    }

}
