package testing;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DeleteMe {
	public void start(final BufferedImage img) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageFrame frame = new ImageFrame(img);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}
}

class ImageFrame extends JFrame {

	public ImageFrame(BufferedImage img) {
		setTitle("ImageTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		ImageComponent component = new ImageComponent(img);
		add(component);

	}

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
}

class ImageComponent extends JComponent {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private Image image;

	public ImageComponent(BufferedImage img) {
		image = img;
		image = image.getScaledInstance(600, 960, java.awt.Image.SCALE_SMOOTH);
	}

	public void paintComponent(Graphics g) {
		if (image == null) return;
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);

		g.drawImage(image, 2, 0, this);

	}

}