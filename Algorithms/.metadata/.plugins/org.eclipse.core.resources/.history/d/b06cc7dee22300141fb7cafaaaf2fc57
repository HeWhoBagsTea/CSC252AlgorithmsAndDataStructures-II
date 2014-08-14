
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str = "1";
//		byte[] ba = str.getBytes();
		byte[] b = new byte[] { 45, 56, 67, 78, 89, 12, 23, 34, 45, 23, 45, 67, 45 };
		byte[] test = new byte[] { 45, 45, 67, 67, 23};
		byte bit = 67;
		HuffmanTree ht = new HuffmanTree(b);
//		ht.printNodes();
		
		Bits bits = new Bits();
//		bits.add(true);
//		bits.add(true);
//		bits.add(true);
//		bits.add(false);
//		System.out.println(ht.toByte(bits));
//		ht.fromByte(bit, bits);
		
		HuffmanCompressor hc = new HuffmanCompressor();
		byte[] compressed = hc.compress(ht, test);
		
//		System.out.println();
		for(int i = 0; i < compressed.length; i++)
			System.out.print(compressed[i] + " ");
		
		
		System.out.println();
		byte[] decompressed = hc.decompress(ht, 13, compressed);
		for(int i = 0; i < decompressed.length; i++)
			System.out.print(decompressed[i] + " ");
	}

}
