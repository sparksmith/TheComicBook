/**
 * 
 */
package start;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import openBook.ImageExtractingService;
import openBook.ImageExtractingService.Destination;
import metadataExtractor.ArchiveSpecificFunctionality;
import metadataExtractor.LibraryPopulatorService;

import com.github.junrar.exception.RarException;

import testing.DeleteMe;
import types.ComicBook;
import exceptions.fileNotFound;

/**
 * @author Ivaylo Ivanchev
 * 
 */
class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer numberOfPages = 5;
		File path = new File("/Users/sparksmith/comicReader/");
		DeleteMe testing = new DeleteMe();

		//LibraryPopulatorService archiver = new LibraryPopulatorService();
		try {
			ComicBook test = LibraryPopulatorService.getComicBook(new File("/Users/sparksmith/Documents/Programming/GITHUB/TheComicBook/"
					+ "The Comic Book/testFiles/testComic2.cbz"));
			System.out.println("The file: " + test.getFileName() + "\n" + "With size: " + test.getFileSize() + "MB\n" + "With filetype: "
					+ test.getFileType() + "\n" + "With original archiving method: " + test.getOriginalArchiving() + "\n"
					+ "With number of pages: " + test.getNumberOfPages());
			ArrayList<BufferedImage> t2 = ImageExtractingService.getImages(test, path, 22,33, Destination.RAM);
			System.out.println("Size: " + t2.size());
			testing.start(t2.get(3));
		} catch (fileNotFound | IOException | RarException e) {
			e.printStackTrace();
		}
	}
}
