import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image
{
	public static void main(String args[]) throws IOException
	{
		BatchFileTransform ft = new BatchFileTransform();
		ImageTransform grey = new Greyscale();
		ft.TransformAll(args[0], grey);
	}
}