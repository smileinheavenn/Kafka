package com.ichiba;

public class VersionUtil {
    static String getVersion() {
        try {
            return VersionUtil.class.getPackage().getImplementationVersion();
        } catch (Exception ex) {
            return "0.1.0";
        }
    }
}
