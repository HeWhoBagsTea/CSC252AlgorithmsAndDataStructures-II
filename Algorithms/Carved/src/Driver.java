
public class Driver {

	public static void main(String[] args) {
		Picture pic = new Picture("overlayimagewithhiddenmessage.png");

		SeamCarver sc = new SeamCarver(pic);
		//		sc.calculateAndEvaluateAllEnergy();

		//		for(int i = 0; i < sc.energyVertical.length; i++) {
		//			for(int j = 0; j < sc.energyVertical[i].length; j++) {
		//				System.out.print(sc.energyVertical[i][j] + ", ");
		//			}
		//			System.out.println();
		//		}

		//		int[] vseam = sc.findHorizontalSeam();
		//
		//		System.out.println();
		//		for(int i = 0; i < vseam.length; i++) {
		//			System.out.println(vseam[i]);
		//		}


		int numberOfVerticalSeamsToRemove = 175;

		for(int i = 0; i < numberOfVerticalSeamsToRemove; i++)
		{
			int[] vSeam = sc.findVerticalSeam();
			sc.removeVerticalSeam(vSeam);
			int[] hSeam = sc.findHorizontalSeam();
			sc.removeHorizontalSeam(hSeam);
		}
		
		for(int i = 0; i < 30; i++)
		{
			int[] vSeam = sc.findVerticalSeam();
			sc.removeVerticalSeam(vSeam);
		}

		
//		int numberOfHorizontalSeamsToRemove = 100;
//
//		for(int i = 0; i < numberOfHorizontalSeamsToRemove; i++)
//		{
//			int[] hSeam = sc.findHorizontalSeam();
//			sc.removeHorizontalSeam(hSeam);
//		}

		pic.show();
		sc.getPicture().show();
		//	

	}
}
