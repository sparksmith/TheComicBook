/**
 * 
 */
package types;

import java.io.File;

import types.Enumeration.ArchiveTypes;

/**
 * @author Ivaylo Ivanchev
 *
 */
public class ComicBook {
	private Metadata metadata; // this will definately change in time
	private Integer numberOfPages;
	private String fileSystemPath;
	private long fileSize;
	private String fileType; // this needs to be replaced by some form of enum
	private Boolean finished; // is this comic read ?
	private Boolean opened; // is this comic book even opened yet ?
	private Integer position; // where did the user stop reading this comic book 
	private String filename;  // filename without path
	private ArchiveTypes originalArchiving;

	public ComicBook(File entry) {
		this.fileSystemPath = entry.getAbsolutePath();
		this.setFileSize((entry.length() / 1000) / 1000);
		this.setFileType(entry.getName().split("\\.")[1]);
		this.opened = false;
		this.position = 0;
		this.finished = false;
		this.setFileName(entry.getName());
		switch (fileType) {
		case "cbr":
			originalArchiving = ArchiveTypes.RAR;
			break;
		case "cbz":
			originalArchiving = ArchiveTypes.ZIP;
			break;
		case "cba":
			originalArchiving = ArchiveTypes.ACE;
			break;
		case "cbt":
			originalArchiving = ArchiveTypes.TAR;
			break;
		case "cb7":
			originalArchiving = ArchiveTypes.SEVENz;
			break;
		}
	}

	public String getFileSystempath() {
		return fileSystemPath;
	}

	public void setFileSystempath(String fileSystempath) {
		this.fileSystemPath = fileSystempath;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getFileName() {
		return filename;
	}

	public void setFileName(String filename) {
		this.filename = filename;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public ArchiveTypes getOriginalArchiving() {
		return originalArchiving;
	}

	public void setOriginalArchiving(ArchiveTypes originalArchiving) {
		this.originalArchiving = originalArchiving;
	}

}
