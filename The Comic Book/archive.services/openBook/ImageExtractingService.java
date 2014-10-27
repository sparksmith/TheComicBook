/**
 * 
 */
package openBook;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

import exceptions.fileNotFound;
import types.ComicBook;

/**
 * @author Ivaylo Ivanchev
 * @metric 1004619i
 * @date 26 Oct 2014
 *
 */
abstract public class ImageExtractingService {
	public enum Destination {
		RAM, HDD
	}

	public static ArrayList<BufferedImage> getImages(ComicBook comic, File path, Integer numberOfPages, Destination d) throws fileNotFound,
			IOException {
		switch (comic.getOriginalArchiving()) {
		case ZIP:
			if (d == d.RAM) {
				return fromZipInMemory(comic, numberOfPages);
			} else if (d == d.HDD) {
				//TODO: Extract the data to PATH folder and use the images from there
				return fromZipInHardDisk(comic, path);
			}
		case RAR:
			//TODO: Create the array for rar files
			break;
		case TAR:
			//TODO: Create the array for tar files
			break;
		case SEVENz:
			//TODO: Create the array for 7z files
			break;
		case ACE:
			//TODO: Create the array for ace files
			break;
		default:
			throw new fileNotFound("Unknown File Type on image Extraction step");
		}
		return null;
	}

	private static ArrayList<BufferedImage> fromZipInMemory(ComicBook comic, Integer numberOfPages) throws IOException {
		ArrayList<BufferedImage> result = new ArrayList<BufferedImage>();

		ZipFile zip = new ZipFile(comic.getFileSystempath());
		final Enumeration<? extends ZipEntry> entries = zip.entries();
		System.out.println("Extraction starting");
		while (entries.hasMoreElements() && numberOfPages > 0) {
			final ZipEntry entry = entries.nextElement();
			if (entry.getName().contains(".jpg")) {
				result.add(ImageIO.read(zip.getInputStream(entry)));
			}
			System.out.println("N: " + numberOfPages);
			numberOfPages--;
		}
		zip.close();
		return result;
	}

	private static ArrayList<BufferedImage> fromZipInHardDisk(ComicBook comic, File path) throws IOException {
		return null;
	}

}
