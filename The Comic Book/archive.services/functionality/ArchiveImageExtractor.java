package functionality;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import types.ComicBook;

interface ArchiveImageExtractor {
	ArrayList<BufferedImage> fromZipInMemory(ComicBook comic, Integer startPage, Integer endPage) throws IOException;

	ArrayList<BufferedImage> fromZipInHDD(ComicBook comic, File path) throws IOException;

	ArrayList<BufferedImage> fromRarInMemory(ComicBook comic, Integer startPage, Integer endPage) throws IOException;

	ArrayList<BufferedImage> fromRarInHDD(ComicBook comic, File path) throws IOException;
}
