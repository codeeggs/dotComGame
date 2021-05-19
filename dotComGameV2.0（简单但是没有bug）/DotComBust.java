import java.util.*;

import java.util.ArrayList;

/**
 * DotComBustion这个类有三个主要的任务:
 * 		1.启动游戏
 * 		2.进行游戏直到所有DotComGame都被击沉为止
 */
public class DotComBust {
	//声明并初始化变量
	private GameHelper helper =new GameHelper();
	private ArrayList<DotCom> dotComsList=new ArrayList<DotCom>();
	private int numOfGuesses=0;

	//创建3个DotComGame对象并植入ArrayList
	private void setUpGame(){
		DotCom one=new DotCom();
		one.setName("Pet.com");
		DotCom two=new DotCom();
		two.setName("eToys.com");
		DotCom three=new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		//列出简短的提示
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pet.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guess");
		//对list中所有的DotComGame重复
		for (DotCom dotComToSet:dotComsList){
			//
			ArrayList<String>newLocation=helper.placeDotCom(3);
			//
			dotComToSet.setLocationCells(newLocation);
		}
	}
	private void startPlaying(){
		//判断DotComGame的list是否为空
		while(!dotComsList.isEmpty()){
			//取得玩家输入的值
			String userGuess=helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
	}
	private void checkUserGuess(String userGuess){
		//累计玩家猜测的次数
		numOfGuesses++;
		//先假设没有命中
		String result="miss";
		//对list中所有的DotCom重复
		for (DotCom dotComToTest:dotComsList){
			//要求DotCom检查是否命中或击沉
			result =dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")){
				//提前跳出循环4
				break;
			}
			if (result.equals("kill")){
				//kill it
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);

	}
	//列出玩家的成绩
	private void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if(numOfGuesses<=18){
			System.out.println("It only took you "+numOfGuesses+" guesses.");
			System.out.println("You got out before your option sank.");
		}else{
			System.out.println("Took you long enough."+numOfGuesses+"guesses.");
			System.out.println("Fish are dancing with your options");
		}
	}
	public static void main(String[] args){
		//创建游戏对象
		DotComBust game =new DotComBust();
		//游戏对象启动
		game.setUpGame();
		//游戏对象启动游戏的主要循环
		game.startPlaying();
	}

}
