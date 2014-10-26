package metadataExtractor;

import java.io.IOException;

import com.github.junrar.exception.RarException;

import types.ComicBook;

public interface ArchiveOpener {
	public ComicBook openRar(ComicBook result) throws RarException, IOException;
	public ComicBook openZip(ComicBook result) throws IOException;
	public ComicBook open7z(ComicBook result);
	public ComicBook openTar(ComicBook result);
	public ComicBook openAce(ComicBook result);
}
