/**
 * 
 */
package openBook;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import types.ComicBook;
import types.Enumeration.Destination;
import exceptions.fileNotFound;
import functionality.ImageGatherer;

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
			return (d == Destination.RAM) ? gatherer.fromZipInMemory(comic, startPage, endPage) : gatherer.fromZipInHDD(comic, path);
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
