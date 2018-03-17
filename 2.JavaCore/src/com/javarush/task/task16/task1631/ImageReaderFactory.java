package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory implements ImageReader{

    public static ImageReader getImageReader(ImageTypes img) {
        if(img != null) {
            switch (img) {
                case JPG:
                    return new JpgReader();
                case BMP:
                    return new BmpReader();
                case PNG:
                    return new PngReader();
            }
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return null;
    }
}
