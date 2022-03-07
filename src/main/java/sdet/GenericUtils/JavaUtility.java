package sdet.GenericUtils;

import java.util.Random;

public class JavaUtility {

	/**
	 * this method will return random number
	 * @return
	 */
	public int getrandomnumber()
	{
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
	}
}
