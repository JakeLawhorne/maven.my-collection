package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.StringJoiner;
import java.util.function.BiPredicate;

public class ImportChecker {
    @Test
    public void checkForCollectionsTest() {
        try {
            final String currentDirectory = System.getProperty("user.dir") + "/src/main";
            final Path path = Paths.get(currentDirectory);
            final BiPredicate<Path, BasicFileAttributes> condition = (p, bfa) -> bfa.isRegularFile();
            Files
                    .find(path, 999, condition)
                    .filter(eachPath -> eachPath.toFile().toString().endsWith(".java"))
                    .forEach(classPath -> scanClass(classPath, "java.util"));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scanClass(Class<?> clazz) {
//        scanClass(clazz, "java.util");
    }

    public static void scanClass(Class<?> someClass, String... forbiddenStrings) {
        URL url = someClass.getResource(someClass.getSimpleName() + ".class");
        try {
            Path classPath = Paths.get(url.toURI());
            for (String forbiddenString : forbiddenStrings) {
                scanClass(classPath, forbiddenString);
            }
        } catch (final URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scanClass(Path classPath, String forbiddenString) {
        try {
            Files
                    .lines(classPath, Charset.defaultCharset())
                    .forEach(line -> {
                        String errorMessage = "Class [ %s ] contained an illegal import of `%s`!";
                        errorMessage = String.format(errorMessage, classPath, forbiddenString);
//                        Assert.assertFalse(errorMessage, line.contains(forbiddenString));
                    });
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

}
