package com.springinaction.firstmvc.service;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.Canvas;
import net.coobird.thumbnailator.filters.Colorize;
import net.coobird.thumbnailator.geometry.Positions;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageIOTest {
    private static final int MAX_WIDTH = 100;
    private static final int MAX_HEIGHT = 100;
    private static final Color OVERLAY_COLOR = Color.decode("#99CCFF");

    public static void main(String... args) throws IOException {
        Thumbnails
                .of(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg"))
                .size(MAX_WIDTH, MAX_HEIGHT)
                .addFilter(new Canvas(MAX_WIDTH, MAX_HEIGHT, Positions.CENTER, Color.WHITE))
                .addFilter(new Colorize(OVERLAY_COLOR, 0.5f))
                .toFile(new File("C:\\Temp\\test-picture.jpg"));
    }
}
