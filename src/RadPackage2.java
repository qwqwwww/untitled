import java.util.Scanner;

public class RadPackage2 {
    public static void main(String[] args) {
        final int num;//红包个数
        int way;//红包方式
        final double coin;//总计金额
        double mon;//单个金额
        System.out.println("输入红包个数");
        Scanner number=new Scanner(System.in);
        num=number.nextInt();
        while (true){
        if (num<=0){
            System.out.println("请输入大于0的整数"+"\n"+"请重新输入");
           } else
               break;
        }
        System.out.println("请输入红包总金额");
        Scanner money1=new Scanner(System.in);
        coin=money1.nextDouble();
    }
}
