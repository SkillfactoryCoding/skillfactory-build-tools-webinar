package ru.skillfactory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Data
@Slf4j
public class FileOperator {

    private long stringRead;

    public String read(String rawPath) throws IOException {
        Path path = Paths.get(rawPath);
        List<String> strings = Files.readAllLines(path);
        log.debug("Success read");
        return strings.get(0);
    }

    public List<String> readAsList(String rawPath) throws IOException {
        Path path = Paths.get(rawPath);
        List<String> reads = Files.readAllLines(path);
        stringRead += reads.size();
        log.debug("Success read lines = " + reads.size());
        return reads;
    }

    public void write(String data, String rawPath) throws IOException {
        Path path = Paths.get(rawPath);
        Files.write(path, data.getBytes());
    }
}
