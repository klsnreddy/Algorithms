package str.arr;

public class BitWise {

	public static void main(String[] args) {

		byte b = 0;
		System.out.println(b);
		b = (byte) (~b);
		System.out.println(b);
		b = (byte) (b << 1);
		System.out.println(b);
		b = (byte) (b << 1);
		System.out.println(b);
	}

}
