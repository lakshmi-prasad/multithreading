
public class SampleString {

	public static void main(String[] args) {
		SampleString ss = new SampleString();
		
		String  [] S = {"b bb      bb", "1+2", "1 + 2"};
		for (String st: S) {
			System.out.println("modified: " + ss.modify(st));
		}
	}
	
	public String modify(String str) {
		String [] in = str.split(" ");
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<in.length; i++) {
			if (in[i].length() < 1) {
				continue;
			}
			sb.append(in[i] + "+");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
