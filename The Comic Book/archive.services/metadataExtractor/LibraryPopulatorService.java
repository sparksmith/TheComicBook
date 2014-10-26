/**
 * 
 */
package metadataExtractor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import types.ComicBook;

import com.github.junrar.exception.RarException;

import exceptions.fileNotFound;

/**
 * @author Ivaylo Ivanchev
 *
 */
abstract public class LibraryPopulatorService {

	public LibraryPopulatorService() {
	}

	/**
	 * Get the file, analyze it and return a filled in ComicBook
	 * 
	 * @param file
	 *            -> the absolute path to the file
	 * @return ComicBook -> filled with metadata that can be extracted and the
	 *         images
	 * @throws fileNotFound
	 *             the file does not exists
	 * @throws IOException
	 *             the file can't be read
	 * @throws RarException
	 *             the file can't be un-archived
	 */
	private static ComicBook fromFile(final File file) throws fileNotFound, IOException, RarException {
		ArchiveSpecificFunctionality opener = new ArchiveSpecificFunctionality();
		ComicBook result = null;
		if (file.exists()) {
			result = new ComicBook(file);
			switch (result.getOriginalArchiving()) {
			// ZIP
			case ZIP:
				result = opener.openZip(result);
				//TODO: extract more metadata information if there is a metadata.info file
				break;
			// RAR -> is a bit special because it is not in the JDK
			case RAR:
				result = opener.openRar(result);
				//TODO: extract more metadata information if there is a metadata.info file
				break;
			case TAR:
				//TODO: Do the tar
				throw new fileNotFound("NOT IMPLEMENTED TAR TYPE");
				//break;
			case SEVENz:
				//TODO: Do the 7z
				throw new fileNotFound("NOT IMPLEMENTED 7z TYPE");
				//break;
			case ACE:
				//TODO: Do the ACE
				throw new fileNotFound("NOT IMPLEMENTED ACE TYPE");
				//break;
			default:
				//TODO: Need to change the error -> unsupported file type
				throw new fileNotFound("Cant unarchive the file");
			}
		} else {
			throw new fileNotFound("Comic book does not exist");
		}
		return result;
	}

	/**
	 * Get a single comic book
	 * 
	 * @param path
	 * @return
	 * @throws fileNotFound
	 * @throws IOException
	 * @throws RarException
	 */
	public static ComicBook getComicBook(final File path) throws fileNotFound, IOException, RarException {
		return fromFile(path);
	}

	/**
	 * Get a folder of comic books
	 * 
	 * @param path
	 * @return
	 */
	public ArrayList<ComicBook> getComicBooks(final File path) {
		return null;
	}
}
