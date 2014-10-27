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
import functionality.ImageGatherer;
import types.ComicBook;
import types.Enumeration.Destination;

/**
 * @author Ivaylo Ivanchev
 * @metric 1004619i
 * @date 26 Oct 2014
 *
 */
abstract public class ImageExtractingService {
	public static ArrayList<BufferedImage> getImages(ComicBook comic, File path, Integer startPage, Integer endPage, Destination d)
			throws fileNotFound, IOException {

		ImageGatherer gatherer = new ImageGatherer();
		switch (comic.getOriginalArchiving()) {
		case ZIP:
			if (d == d.RAM) {
				return gatherer.fromZipInMemory(comic, startPage, endPage);
			} else if (d == d.HDD) {
				//TODO: Extract the data to PATH folder and use the images from there
				return gatherer.fromZipInHDD(comic, path);
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
}
