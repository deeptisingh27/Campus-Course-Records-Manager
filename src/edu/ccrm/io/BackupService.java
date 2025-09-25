package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {
    public static void backupFolder(String sourceDir, String backupRoot) {
        Path source = Path.of(sourceDir);
        if (!Files.exists(source)) {
            System.out.println("Source folder not found: " + sourceDir);
            return;
        }
        String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Path target = Path.of(backupRoot, "backup-" + stamp);
        try {
            Files.createDirectories(target);
            Files.walk(source).forEach(src -> {
                try {
                    Path rel = source.relativize(src);
                    Path dest = target.resolve(rel);
                    if (Files.isDirectory(src)) {
                        if (!Files.exists(dest)) Files.createDirectories(dest);
                    } else {
                        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    System.err.println("Copy failed: " + e.getMessage());
                }
            });
            System.out.println("Backup created at: " + target.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Backup failed: " + e.getMessage());
        }
    }
}
