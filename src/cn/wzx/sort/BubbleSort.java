package cn.wzx.sort;
/**
 * ц╟ещеепР
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] intarr=new int[] {8,1,9,7,53,11,23,4,6,7};
		for (int i = 0; i < intarr.length; i++) {
			for (int j = i+1; j < intarr.length; j++) {
				if(intarr[i]>intarr[j]) {
					int temp=intarr[i];
					intarr[i]=intarr[j];
					intarr[j]=temp;
				}
			}
		}
		arrToString(intarr);
	}
	
	
	public static void arrToString(int [] intarr) {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for (int i = 0; i < intarr.length; i++) {
			sb.append(intarr[i]);
			sb.append(",");
		}
		sb.setCharAt(sb.length()-1, ']');
		System.out.println(sb.toString());
	}
}
