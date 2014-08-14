
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "heeeelooaaaaymndddccxiii           wwwr";
		String str2 = "hello world";
		byte[] strBa = str1.getBytes();
		byte[] ba = new byte[] { 45, 56, 67, 78, 89, 12, 23, 34, 45, 23, 45, 67, 45 };
		byte[] testStr = str2.getBytes();
		byte[] testInt = new byte[] {45, 45, 67, 67, 23};
//		ht.printNodes();
		
		HuffmanTree ht = new HuffmanTree(ba);
		
		
		HuffmanCompressor hc = new HuffmanCompressor();
		byte[] compressed = hc.compress(ht, testInt);
		
		for(int i = 0; i < compressed.length; i++)
			System.out.print(compressed[i] + " ");
		
		System.out.println();
		byte[] decompressed = hc.decompress(ht, 13, compressed);
		for(int i = 0; i < decompressed.length; i++)
			System.out.print(decompressed[i] + " ");
//		
//		HuffmanTree ht = new HuffmanTree(strBa);
//		HuffmanCompressor hc = new HuffmanCompressor();
//		byte[] compressed = hc.compress(ht, testStr);
//		
//		for(int i = 0; i < compressed.length; i++)
//			System.out.print(compressed[i] + " ");
//		
//		System.out.println();
//		byte[] decompressed = hc.decompress(ht, 48, compressed);
//		for(int i = 0; i < decompressed.length; i++)
//			System.out.print(decompressed[i] + " ");
//		
//		System.out.println();
//		char[] ascii = hc.convertAscii(decompressed);
//		for(int i = 0; i < ascii.length; i++)
//			System.out.print(ascii[i]);
	}

}