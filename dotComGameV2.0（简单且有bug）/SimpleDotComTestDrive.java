public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        //初始化一个SimpleDotCom对象
        SimpleDotCom dot = new SimpleDotCom();
        //创建带有DotComGame位置的数组
        int[] locations = {2, 3, 4};
        //调用DotCom的setter
        dot.setLocationCells(locations);
        //测试用的假猜测
        String userGuess = "1";
        //调用北侧方法，并传入假猜测
        String result = dot.checkYourself(userGuess);
        //测试应该
        String testResult="failed";
        if(result.equals("hit")){
            testResult="passed";
        }
    }
}
