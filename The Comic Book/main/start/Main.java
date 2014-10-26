/**
 * 
 */
package start;

import java.io.File;
import java.io.IOException;

import com.github.junrar.exception.RarException;

import types.ComicBook;
import zipSolution.OpenZip;
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
		System.out.println("Yo, world");
		OpenZip archiver = new OpenZip();
		try {
			ComicBook test = archiver.fromFile(new File("/Users/sparksmith/Documents/Programming/GITHUB/TheComicBook/"
					+ "The Comic Book/testFiles/testComic2.cbz"));
			System.out.println("The file: " + test.getFileName() + "\n" + "With size: " + test.getFileSize() + "MB\n" + "With filetype: "
					+ test.getFileType() + "\n" + "With original archiving method: " + test.getOriginalArchiving() + "\n"
					+ "With number of pages: " + test.getNumberOfPages());
		} catch (fileNotFound | IOException | RarException e) {
			e.printStackTrace();
		}
	}
}
