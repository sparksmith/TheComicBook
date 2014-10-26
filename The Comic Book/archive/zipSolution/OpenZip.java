/**
 * 
 */
package zipSolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import types.ComicBook;
import exceptions.fileNotFound;

/**
 * @author Ivaylo Ivanchev
 *
 */
public class OpenZip {
	public ComicBook fromFile(final File file) throws fileNotFound, IOException {
		ComicBook result = null;
		if (file.exists()) {
			result = new ComicBook(file);
			int numberOfPages = 0;
			switch (result.getOriginalArchiving()) {
			case ZIP:
				ZipFile comic = new ZipFile(result.getFileSystempath());
				final Enumeration<? extends ZipEntry> entries = comic.entries();
				while (entries.hasMoreElements()) {
					final ZipEntry entry = entries.nextElement();
					if (entry.getName().contains(".jpg")) {
						numberOfPages++;
					}
				}
				result.setNumberOfPages(numberOfPages);
				comic.close();
				break;
			default:
				//TODO: Need to change the error
				throw new fileNotFound("Cant unarchive the file");
			}
		} else {
			throw new fileNotFound("Comic book does not exist");
		}
		return result;
	}

	public ArrayList<ComicBook> fromFolder(final File path) throws fileNotFound {
		boolean comicBooksExist = false;
		ArrayList<ComicBook> result = new ArrayList<ComicBook>();
		for (final File entry : path.listFiles()) {
			System.out.println(entry.getName());
			if (entry.getName().contains(".cb")) {
				comicBooksExist = true;
				result.add(new ComicBook(entry));
				// add metadata
				// number of pages
			}
		}

		if (comicBooksExist == false) {
			throw new fileNotFound("No comic books in folder");
		}

		return result;
	}
}
