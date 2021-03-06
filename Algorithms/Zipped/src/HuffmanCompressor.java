import java.util.ArrayList;
import java.util.List;


public class HuffmanCompressor {
	public byte[] compress(HuffmanTree tree, byte[] b) {
		Bits bits = new Bits();

		for(int i = 0; i < b.length; i++) 
			tree.fromByte(b[i], bits);

		int padding = 8 - (bits.size() % 8);
		
		byte[] compressedBytes = new byte[bits.size() + padding];
		for(int i = 0; i < compressedBytes.length; i++) {
			if(!bits.isEmpty()) {
				if(bits.poll())
					compressedBytes[i] = 1;
				else
					compressedBytes[i] = 0;
			}
		}

		return compressedBytes;
	}

	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] b) {
		Bits bits = new Bits();
		byte[] decompressedBytes = new byte[uncompressedLength];
		for(int i = 0; i < b.length; i++) {
			if(b[i] == 0)
				bits.add(false);
			else
				bits.add(true);
		}
		
		List<Byte> bl = new ArrayList<Byte>();
		
		while(!bits.isEmpty()) {
			bl.add(tree.toByte(bits));
		}
		
		for(int i = 0; i < uncompressedLength; i++)
			decompressedBytes[i] = bl.get(i);
		
		return decompressedBytes;
	}
	
	public char[] convertAscii(byte[] b) {
		char[] ca = new char[b.length];
		for(int i = 0; i < b.length; i++) {
			ca[i] = (char)b[i];
		}
		return ca;
	}

}
