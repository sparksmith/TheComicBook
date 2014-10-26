/**
 * 
 */
package start;

import java.io.File;
import java.io.IOException;

import metadataExtractor.LibraryPopulatorService;

import com.github.junrar.exception.RarException;

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
		//LibraryPopulatorService archiver = new LibraryPopulatorService();
		try {
			ComicBook test = LibraryPopulatorService.getComicBook(new File("/Users/sparksmith/Documents/Programming/GITHUB/TheComicBook/"
					+ "The Comic Book/testFiles/testComic1.cbr"));
			System.out.println("The file: " + test.getFileName() + "\n" + "With size: " + test.getFileSize() + "MB\n" + "With filetype: "
					+ test.getFileType() + "\n" + "With original archiving method: " + test.getOriginalArchiving() + "\n"
					+ "With number of pages: " + test.getNumberOfPages());
		} catch (fileNotFound | IOException | RarException e) {
			e.printStackTrace();
		}
	}
}
