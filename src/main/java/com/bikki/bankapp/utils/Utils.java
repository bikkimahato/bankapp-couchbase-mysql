package com.bikki.bankapp.utils;

import java.util.UUID;

public class Utils {
    public static String generateRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
