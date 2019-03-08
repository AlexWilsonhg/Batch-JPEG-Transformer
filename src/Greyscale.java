import java.awt.image.BufferedImage;

public class Greyscale implements ImageTransform
{
	// Takes in image and returns an image converted to greyscale.
	@Override
	public BufferedImage Transform(BufferedImage inImage)
	{
		if(inImage == null)
			return null;

		BufferedImage outImage = new BufferedImage(inImage.getWidth(), inImage.getHeight(), BufferedImage.TYPE_INT_BGR);

		for(int y = 0; y < inImage.getHeight(); ++y)
		{
			for(int x = 0; x < inImage.getWidth(); ++x)
			{
				int color = inImage.getRGB(x, y);
				int red   = (color & 0x00ff0000) >> 16;
				int green = (color & 0x0000ff00) >> 8;
				int blue  = (color & 0x000000ff);
				int average = (red+green+blue)/3;

				int colorOut = 0;
				colorOut = (colorOut | (average << 16));
				colorOut = (colorOut | (average << 8));
				colorOut = (colorOut | average);

				outImage.setRGB(x, y, colorOut);
			}
		}
		
		return outImage;
	}	
}