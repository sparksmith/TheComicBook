/**
 * 
 */
package metadataExtractor;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import types.ComicBook;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

/**
 * @author Ivaylo Ivanchev
 * @metric 1004619i
 * @date 26 Oct 2014
 *
 */
public class ArchiveSpecificFunctionality implements ArchiveOpener {
	/**
	 * Extract information regarding the CBZ format
	 * 
	 * @param result
	 *            contains some of the information regarding the metadata
	 *            already
	 * @return a populated with information Comic Book
	 * @throws IOException
	 */
	public ComicBook openZipAddMetadata(ComicBook result) throws IOException {
		int numberOfPages = 0;

		ZipFile comic = new ZipFile(result.getFileSystempath());
		final Enumeration<? extends ZipEntry> entries = comic.entries();
		while (entries.hasMoreElements()) {
			final ZipEntry entry = entries.nextElement();
			if (entry.getName().contains(".jpg")) {
				numberOfPages++;
			}
		}
		//TODO: Add metadata from file
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
	public ComicBook openRarAddMetadata(ComicBook result) throws RarException, IOException {
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
		//TODO: Add more metadata from file if there is one
		rar.close();
		return result;
	}

	@Override
	public ComicBook open7zAddMetadata(ComicBook result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComicBook openTarAddMetadata(ComicBook result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComicBook openAceAddMetadata(ComicBook result) {
		// TODO Auto-generated method stub
		return null;
	}
}
