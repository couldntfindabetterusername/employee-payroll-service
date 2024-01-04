package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileManagement {
    public boolean checkIfFileExists(String fileName) {
        Path path = Path.of(fileName);

        if (!Files.exists(path))
            return false;

        return true;
    }

    public void deleteFile(String fileName) throws IOException {
        if (!checkIfFileExists(fileName))
            throw new IOException();

        Path path = Path.of(fileName);
        Files.delete(path);
    }

    public void createDirectory(String directoryName) throws IOException {
        Path path = Paths.get(directoryName);
        Files.createDirectory(path);
    }

    public void createFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.createFile(path);
    }

    public ArrayList<String> getAllFiles(String directoryName) throws IOException {
        Path path = Paths.get(directoryName);
        Stream<Path> files = Files.list(path);

        ArrayList<String> result = new ArrayList<>();
        files.forEach(file -> result.add(file.toString()));

        files.close();
        return result;
    }
}
