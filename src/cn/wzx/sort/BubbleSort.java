package cn.wzx.sort;
/**
 * ц╟ещеепР
 *  BubbleSort
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] a=new int[] {8,1,9,7,53,11,23,4,6,7};
		for (int i = 1; i < a.length; i++) {
			if(a[i]<a[i-1]) {
				int temp=a[i];
				int j;
				for (j = i-1; j >=0&&temp<a[j]; j--) {
					a[j+1]=a[j];
				}
				a[j+1]=temp;
			}
		}
	
		arrToString(a);
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
