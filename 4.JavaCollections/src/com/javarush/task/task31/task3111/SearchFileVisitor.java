package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null, partOfContent = null;
    private int minSize = 0, maxSize = 0;
    private List<Path> foundFiles =  new ArrayList<>();
    private boolean minSizeChk, maxSizeChk, partOfNameChk, partOfContChk;

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.partOfNameChk = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.partOfContChk = true;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.minSizeChk = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.maxSizeChk = true;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

         if ((partOfNameChk) && (!file.getFileName().toString().contains(partOfName))) {
            return FileVisitResult.CONTINUE;
        }

        String content = new String(Files.readAllBytes(file));
        if ((partOfContChk) && (!content.contains(partOfContent))) {
            return FileVisitResult.CONTINUE;
        }

        long size = Files.size(file);
        if ((maxSizeChk) && !(size < maxSize)) {
            return FileVisitResult.CONTINUE;
        }

        if ((minSizeChk) && (size < minSize)) {
            return FileVisitResult.CONTINUE;
        }
        foundFiles.add(file);

        return FileVisitResult.CONTINUE;  /*
        if (partOfNameChk && !file.getFileName().toString().contains(partOfName)) {
            return FileVisitResult.CONTINUE;
        }

        if (partOfContChk && !new String(Files.readAllBytes(file)).contains(partOfContent)) {
            return FileVisitResult.CONTINUE;
        }
        if (minSizeChk && attrs.size() < minSize) {
            return FileVisitResult.CONTINUE;
        }
        if (maxSizeChk && attrs.size() > maxSize) {
            return FileVisitResult.CONTINUE;
        }

        foundFiles.add(file);

        return FileVisitResult.CONTINUE; */
    }
}
