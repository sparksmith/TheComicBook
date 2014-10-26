/**
 * 
 */
package zipSolution;

import java.io.File;
import java.util.ArrayList;

import exceptions.fileNotFound;
import types.ComicBook;
import types.ComicBook.ArchiveTypes;

/**
 * @author Ivaylo Ivanchev
 *
 */
public class OpenZip {
	public ComicBook fromFile(final File file) throws fileNotFound {
		ComicBook result = null;
		if (file.exists()) {
			result = new ComicBook(file);
			if(result.getOriginalArchiving() == ArchiveTypes.RAR){
				// add metadata
				// number of pages
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
