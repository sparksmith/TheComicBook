package functionality;

import java.io.IOException;

import com.github.junrar.exception.RarException;

import types.ComicBook;

public interface ArchiveMetadataExtractor {
	public ComicBook openRarAddMetadata(ComicBook result) throws RarException, IOException;
	public ComicBook openZipAddMetadata(ComicBook result) throws IOException;
	public ComicBook open7zAddMetadata(ComicBook result);
	public ComicBook openTarAddMetadata(ComicBook result);
	public ComicBook openAceAddMetadata(ComicBook result);
}
