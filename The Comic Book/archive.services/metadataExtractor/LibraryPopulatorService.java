/**
 * 
 */
package metadataExtractor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import types.ComicBook;
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
		ComicBook result = null;
		if (file.exists()) {
			result = new ComicBook(file);
			switch (result.getOriginalArchiving()) {
			// ZIP
			case ZIP:
				result = openZip(result);
				//TODO: extract more metadata information if there is a metadata.info file
				break;
			// RAR -> is a bit special because it is not in the JDK
			case RAR:
				result = openRar(result);
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
	 * Extract information regarding the CBZ format
	 * 
	 * @param result
	 *            contains some of the information regarding the metadata
	 *            already
	 * @return a populated with information Comic Book
	 * @throws IOException
	 */
	private static ComicBook openZip(ComicBook result) throws IOException {
		int numberOfPages = 0;

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
		return result;
	}

	/**
	 * Extract information regarding the CBR format
	 * 
	 * @param result
	 *            path information about the file
	 * @return more information regarding the file including the page numbers
	 *         and size
	 * @throws RarException
	 * @throws IOException
	 */
	private static ComicBook openRar(ComicBook result) throws RarException, IOException {
		int numberOfPages = 0;
		Archive rar = new Archive(new File(result.getFileSystempath()));
		FileHeader fileHeader = rar.nextFileHeader();
		while (fileHeader != null) {
			if (!fileHeader.isDirectory()) {
				//name = fileHeader.getFileNameString();
				if (fileHeader.getFileNameString().contains(".jpg")) {
					numberOfPages++;
				}
			}
			fileHeader = rar.nextFileHeader();
		}
		result.setNumberOfPages(numberOfPages);
		rar.close();
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
