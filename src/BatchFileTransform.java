import java.io.File;
import java.io.FilenameFilter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class BatchFileTransform
{
	public void TransformAll(String path, ImageTransform transform)
	{
		BufferedImage inImage = null;
		BufferedImage outImage = null;

		File[] files = FileFilter(path);

		new File(path + "/Transformed").mkdirs();

		for(File file : files)
		{
			try
			{
				File dir = new File(path + "/Transformed");
				File outFile = new File(dir, "T_" + file.getName());

				inImage = ImageIO.read(file);
				outImage = transform.Transform(inImage);
				ImageIO.write(outImage, "jpg", outFile);
				System.out.println("Converting file " + file.getName() + " ...");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	private File[] FileFilter(String path)
	{
		File dir = new File(path);
		File[] fileListing = dir.listFiles(new FilenameFilter() {
             
            @Override
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".jpg"))
                {
                    return true;
                } 
                else {
                    return false;
                }
            }
        });
        return fileListing;
    }
}