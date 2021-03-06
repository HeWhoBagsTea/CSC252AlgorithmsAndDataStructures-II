import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "heeeelooaaaaymndddccxiii           wwwr";
		String str2 = "hello world";
		byte[] strBa = str1.getBytes();
		byte[] ba = new byte[] { -45, 56, 67, 78, 89, 12, 23, 34, 45, 23, 45, 67, 45 };
		byte[] testStr = str2.getBytes();
		byte[] testInt = new byte[] {-45, 45, 67, 67, 23};
//		ht.printNodes();
		
		File outputFile = new File("image.jpeg");
		Path path = Paths.get("compressed.huff");
		byte[] data = new byte[0];
		try {
			data = Files.readAllBytes(path);
			ImageIcon imageIcon = new ImageIcon(data);
			Image image = imageIcon.getImage();
			BufferedImage buffered = toBufferedImage(image);
			ImageIO.write(buffered, "jpeg", outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//-----------------------testInt-----------------------------------------------		
//		HuffmanTree ht = new HuffmanTree(ba);
//		
//		HuffmanCompressor hc = new HuffmanCompressor();
//		byte[] compressed = hc.compress(ht, testInt);
//		
//		for(int i = 0; i < compressed.length; i++)
//			System.out.print(compressed[i] + " ");
//		
//		System.out.println();
//		byte[] decompressed = hc.decompress(ht, testInt.length, compressed);
//		for(int i = 0; i < decompressed.length; i++)
//			System.out.print(decompressed[i] + " ");
		
		
//-----------------------testStr-----------------------------------------------		
		HuffmanTree ht = new HuffmanTree(strBa);
		HuffmanCompressor hc = new HuffmanCompressor();
		byte[] compressed = hc.compress(ht, testStr);
		
		for(int i = 0; i < compressed.length; i++)
			System.out.print(compressed[i] + " ");
		
		System.out.println();
		byte[] decompressed = hc.decompress(ht, testStr.length, compressed);
		for(int i = 0; i < decompressed.length; i++)
			System.out.print(decompressed[i] + " ");
		
		System.out.println();
		char[] ascii = hc.convertAscii(decompressed);
		for(int i = 0; i < ascii.length; i++)
			System.out.print(ascii[i]);
		
	}
	
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}

}
