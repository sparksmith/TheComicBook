/**
 * 
 */
package openBook;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import types.ComicBook;

/**
 * @author Ivaylo Ivanchev
 * @metric 1004619i
 * @date 26 Oct 2014
 *
 */
abstract public class ImageExtractingService {
	public ArrayList<BufferedImage> getImages(ComicBook comic, File path){
		//TODO: get a comicbook filled with metadata and extract it based on the default path 
		return null;	
	}
}
