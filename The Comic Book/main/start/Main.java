/**
 * 
 */
package start;

import java.io.File;
import java.util.ArrayList;

import types.ComicBook;
import exceptions.fileNotFound;
import zipSolution.OpenZip;

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
					+ "The Comic Book/testFiles/testComic1.cbr"));
			System.out.println("The file: " + test.getFileName() + "\n" + "With size: " + test.getFileSize() + "\n" + "With filetype: "
					+ test.getFileType() + "\n" + "With original archiving method: " + test.getOriginalArchiving());
		} catch (fileNotFound e) {
			e.printStackTrace();
		}
	}
}
