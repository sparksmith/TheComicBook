package functionality;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

import types.ComicBook;

public class ImageGatherer implements ArchiveImageExtractor {

	@Override
	public ArrayList<BufferedImage> fromZipInMemory(ComicBook comic, Integer startPage, Integer endPage) throws IOException {
		ArrayList<BufferedImage> result = new ArrayList<BufferedImage>();

		ZipFile zip = new ZipFile(comic.getFileSystempath());
		final Enumeration<? extends ZipEntry> entries = zip.entries();

		int currentEntry = 0;
		while (entries.hasMoreElements()) {
			final ZipEntry entry = entries.nextElement();
			if (entry.getName().contains(".jpg") && (currentEntry >= startPage && currentEntry <= endPage)) {
				result.add(ImageIO.read(zip.getInputStream(entry)));
			} else if (currentEntry > endPage) {
				break;
			}
			currentEntry++;
		}
		zip.close();
		return result;
	}

	@Override
	public ArrayList<BufferedImage> fromZipInHDD(ComicBook comic, File path) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BufferedImage> fromRarInMemory(ComicBook comic, Integer startPage, Integer endPage) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BufferedImage> fromRarInHDD(ComicBook comic, File path) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
