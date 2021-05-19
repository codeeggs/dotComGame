/**
 * 此版版本的bug在于：可以通过击中同一个dotcom三次来获得胜利
 */

import sun.java2d.pipe.SpanShapeRenderer;

public class SimpleDotConGame {
	public static void main(String[] args) {
		//记录玩家猜测次数的变量
		int numOfGuesses = 0;
		//取得玩家的输入，先假装这是Java提供的
		GameHelper helper = new GameHelper();
		//创建DotCon对象
		SimpleDotCom theDotCom = new SimpleDotCom();
		//用随机数产生第一格的位置，然后以此制作出数组
		int randomNum = (int) (Math.random() * 5);
		int[] locations = {randomNum, randomNum + 1, randomNum + 2};
		//赋值位置
		theDotCom.setLocationCells(locations);
		//创建出记录游戏是否进行的boolean变量，这会用在while循环中
		boolean isAlive = true;

		while (isAlive == true) {
			//取得玩家输入的字符串
			String guess = helper.getUserInput("enter a number");
			//检查玩家的猜测并将结果存储在result中
			String result = theDotCom.checkYourself(guess);
			//累加猜测次数 increment guess count
			numOfGuesses++;
			//判断是否击沉？若击沉，则设定isAlive为false并印出猜测次数
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
}