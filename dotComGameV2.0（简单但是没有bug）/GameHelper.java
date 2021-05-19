//
//import java.io.*;
//import java.util.*;
//
//public class GameHelper {
//	private static final String alphabet = "abcdefg";
//	private int gridLength = 7;
//	private int gridSize = 49;
//	private int[] grid = new int[gridSize];
//	private int comCount = 0;
//
//	public String getUserInput(String prompt) {
//		String inputLine = null;
//		System.out.println(prompt + "  ");
//		try {
//			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
//			inputLine = is.readLine();
//			if (inputLine.length() == 0) return null;
//		} catch (IOException e) {
//			System.out.println("IOException: " + e);
//		}
//		return inputLine.toLowerCase();
//	}
//
//	public ArrayList<String> placeDotCom(int comSize) {
//		ArrayList<String> alphaCells = new ArrayList<String>();
//		String[] alphacoords = new String[comSize];
//		String temp = null;
//		int[] coords = new int[comSize];
//		int attempts = 0;
//		boolean success = false;
//		int location = 0;
//		comCount++;
//		int incr = 1;
//		if ((comCount % 2) == 1) {
//			incr = gridLength;
//		}
//		while (!success & attempts++ < 200) {
//			location = (int) (Math.random() * gridSize);
//			//
//			System.out.println(" try " + location);
//			int x = 0;
//			success = true;
//			while (success && x < comSize) {
//				if (grid[location] == 0) {
//					coords[x++] = location;
//					location += incr;
//					if (x > 0 && (location % gridLength == 0)) {
//						success = false;
//					}
//				} else {
//					System.out.println(" used " + location);
//					success = false;
//				}
//
//			}
//		}
//		int x = 0;
//		int row = 0;
//		int column = 0;
////		System.out.println("\n");
//		while (x < comSize) {
//			grid[coords[x]] = 1;
//			row = (int) (coords[x] / gridLength);
//			column = coords[x] % gridLength;
//			temp = String.valueOf(alphabet.charAt(column));
//			alphaCells.add(temp.concat(Integer.toString(row)));
//			x++;
//			//下面这一行会显示答案
//			System.out.println(" coord " + x + " = " + alphaCells.get(x - 1));
//		}
//		return alphaCells;
//	}
//}

import java.io.*;
import java.util.*;

public class GameHelper {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;

	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.println(prompt + "  ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		} catch (IOException e) {
			System.out.println("IOExcepiton" + e);
		}
		return inputLine.toLowerCase();
	}

	public ArrayList<String> placeDotCom(int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		//保存字符串
		String[] alphacoords = new String[comSize];
		//临时字符串
		String temp = null;
		//现有字符串
		int[] coords = new int[comSize];
		//目前测试的字符串
		int attempts = 0;
		//找到合适位置吗?
		boolean success = false;
		//目前起点
		int location = 0;
		//现在处理到第n个
		comCount++;
		//水平增量
		int incr = 1;
		//如果的是单数号的
		if ((comCount % 2) == 1) {
			//垂直增量
			incr = gridLength;
		}
		//主要搜索循环
		while (!success & attempts++ < 200) {
			//循环起点
			location = (int) (Math.random() * gridSize);
			//第n个位置
			int x = 0;
			//假定成功
			success = true;
			//查找未使用的点
			while (success && x < comSize) {
				//如果没有使用
				if (grid[location] == 0) {
					//存储位置
					coords[x++] = location;
					//尝试下一个点
					location += incr;
					//超出下边缘
					if (location >= gridSize) {
						//失败
						success = false;
					}
					//超出右边缘
					if (x > 0 && (location % gridLength == 0)) {
						//失败
						success = false;
					}
				}
				//找到已使用的位置
				else {
					//失败
					success = false;
				}
			}
		}
		//将位置转换成字符串形式
		int x = 0;
		int row = 0;
		int column = 0;
		while (x < comSize) {
			//标识格子已经使用
			grid[coords[x]] = 1;
			//得到行的值
			row = (int) (coords[x] / gridLength);
			//得到列的值
			column = coords[x] % gridLength;
			//转换成字符串
			temp = String.valueOf(alphabet.charAt(column));
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			//这一行会显示答案
			System.out.println(" coord " + x + " = " + alphaCells.get(x - 1));
		}
		return alphaCells;
	}
}
