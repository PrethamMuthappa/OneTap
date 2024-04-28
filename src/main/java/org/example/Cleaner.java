package org.example;


import java.io.File;
import java.util.Objects;

public class Cleaner {
    static void recycle(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    recycle(file);
                } else {
                    try {
                        if (!file.delete()) {
                            System.err.println("Failed to delete file: " + file.getAbsolutePath());
                        }
                    } catch (SecurityException e) {
                        System.err.println("SecurityException: " + e.getMessage());
                    }
                }
            }
            if(folder.isDirectory() && Objects.requireNonNull(folder.list()).length == 0) {
                folder.delete();
            }
        }
    }
}
