package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DataService {

    private Path getPackageFolderPath(Class<?> clazz) {
        try {
            String packageName = clazz.getPackage().getName().replaceAll("\\.", "/");
            URL url = clazz.getClassLoader().getResource(packageName);
            return Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getDataPoints(Path inputPath) {
        List<String> data = new LinkedList<>();
        try (Scanner s = new Scanner(inputPath.toFile())) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Input is not present", ex);
        }
        return data;
    }

    public List<String> getInputData(Class<?> clazz) {
        Path inputFolder = getPackageFolderPath(clazz);
        Path inputPath = inputFolder.resolve("input");
        if (!Files.isRegularFile(inputPath)) {
            throw new RuntimeException("Input file is missing. Path: " + inputPath.toString());
        } else {
            File inputFile = inputPath.toFile();
            return getDataPoints(inputPath);
        }
    }
}
