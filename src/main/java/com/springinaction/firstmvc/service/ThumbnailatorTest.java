package com.springinaction.firstmvc.service;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.Canvas;
import net.coobird.thumbnailator.filters.Colorize;
import net.coobird.thumbnailator.geometry.Positions;

import java.awt.*;
import java.io.*;

public class ThumbnailatorTest {
    private static final int MAX_WIDTH = 100;
    private static final int MAX_HEIGHT = 100;
    private static final Color OVERLAY_COLOR = Color.decode("#FF9A40");

    public static void main(String... args) throws IOException {
        Thumbnails
                .of(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg"))
                .size(MAX_WIDTH, MAX_HEIGHT)
                .addFilter(new Canvas(MAX_WIDTH, MAX_HEIGHT, Positions.CENTER, Color.WHITE))
                .addFilter(new Colorize(OVERLAY_COLOR, 0.5f))
                .toFile(new File("C:\\Temp\\test-picture.jpg"));
    }

    static File makeThumbnailOf(File inputFile, File outFile) throws IOException {
        Thumbnails
                .of(inputFile)
                .size(MAX_WIDTH, MAX_HEIGHT)
                .addFilter(new Canvas(MAX_WIDTH, MAX_HEIGHT, Positions.CENTER, Color.WHITE))
                .addFilter(new Colorize(OVERLAY_COLOR, 0.7f))
                .toFile(outFile);

        return outFile;
    }
}
