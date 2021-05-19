public class SimpleDotCom {
	int[] locationCells;
	int numOfHits = 0;

	public void setLocationCells(int[] locationCells) {
		this.locationCells = locationCells;
	}

	public String checkYourself(String stringGuess) {
		//把字符串转换为int
		int guess = Integer.parseInt(stringGuess);
		//创建出保存返回结果的变量。以miss作为默认值
		String result = "miss";
		//以循环对每个格子重复执行
		for (int cell : locationCells) {
			//比较格子与猜测值
			if (guess == cell) {
				//击中
				result = "hit";
				numOfHits++;
				break;
			}
		}
		//已经离开循环，但需要判断是否击沉
		if (numOfHits == locationCells.length) {
			result = "kill";
		}
		//将结果显示出来
		System.out.println(result);
		//将结果返回给调用方
		return result;
	}
}
