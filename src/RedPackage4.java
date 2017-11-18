import java.util.Scanner;

public class RedPackage4 {
    public static void main(String[] args) {
        int num;// 红包的个数
        double cash;// 总钱数
        int way;// 判断红包类型
        int MaxNo;// 记录最大值的位置
        int MinNo;// 记录最小值的位置
        String com;//输入口令
        String re;//回复口令
        String na;//输入名字
        while (true) {
            System.out.println("请输入红包数");
            Scanner number = new Scanner(System.in);
            num = number.nextInt();// 读取用户输入，并存入num变量
            if (num <= 0)// 如果数小于等于0
            {
                System.out.println("输入错误，请输入大于0的整数！" + "\n" + "请重新输入！" + "\n");
            } else
                break;
        }
        System.out.println();
        double[] a = new double[num];// 定义一个double型的有num个元素的数组
        while (true) {
            System.out.println("请輸入总金额");
            Scanner coin = new Scanner(System.in);
            cash = coin.nextDouble();// 读取用户输入，并存入cash变量
            if (1000 * cash % 1 != 0)// 如果用户输入了三位或更多位的小数
            {
                System.out.println("输入错误，请输入最多保留两位的小数" + "\n" + "请重新输入！" + "\n");
            } else if ((cash / num) < 0.01)// 如果每个红包平均分到的金额小于0.01元
            {
                System.out.println("红包数不能少于0.1");
            } else if ((cash / num) > 200)// 如果每个红包平均分到的金额大于200元
            {
                System.out.println("金额错误，单个红包金额不可大于200元，请调整金额和红包数");
            } else
                break;
        }
        System.out.println();
        while (true) {
            System.out.println("请选择红包种类（输入数字）\n1.口令红包\n2.拼手气红包\n3.普通红包\n");
            Scanner pi = new Scanner(System.in);
            way = Integer.parseInt(pi.nextLine());// 读取用户输入，并存入pin变量
            if (way != 1 && way != 2 && way != 3)
                System.out.println("选择错误，请输入1或2或3\n请重新输入！\n");
            else
                break;
        }
            if (way == 1) {
                int c = 0;//记录输入口令次数
                System.out.println("请输入口令");
                Scanner command = new Scanner(System.in);
                com = command.nextLine();
                while (c < a.length) {//循环输入口令
                    System.out.println("请抢红包的老铁输入昵称");
                    Scanner name=new Scanner(System.in);
                    na=name.nextLine();
                    Human per=null;
                    per=new Human(na);
                    per.introduce();
                    System.out.println("回复口令抢红包");
                    Scanner reply = new Scanner(System.in);
                    re = reply.nextLine();
                    if (re.equals(com))//比较口令是否相同
                        System.out.println("成功领取红包");
                    else
                        System.out.println("口令错误，错失红包");
                    c++;
                }
                pinshouqiArray(a, cash);
                double sum2 = Math.round(sum(a) * 100);
                int cash1 = (int) (cash * 100);
                int sum1 = (int) (sum2);
                int resi = cash1 - sum1;
                for (int i = 0; i < resi; i++) {
                    a[(int) (Math.floor(a.length * Math.random()))] += 0.01;
                    sishewuru(a);
                }
                printArray(a);
                double sum3 = Math.round(sum(a) * 100);
                System.out.println("共发出：" + sum3 / 100 + "元");
                MaxNo = Max(a);
                MinNo = Min(a, cash);
                if (MaxNo == MinNo)
                    System.out.println("运气王不存在的");
                else {
                    System.out.println("运气王是" + MaxNo + "号dalao");
                }
            }
        else if (way==2){

                System.out.println("请抢红包的老铁输入昵称");
                Scanner name=new Scanner(System.in);
                na=name.nextLine();
                Human per=null;
                per=new Human(na);
                per.introduce();
                pinshouqiArray(a, cash);
                double sum2 = Math.round(sum(a) * 100);
                int cash1 = (int) (cash * 100);
                int sum1 = (int) (sum2);
                int resi = cash1 - sum1;
                for (int i = 0; i < resi; i++) {
                    a[(int) (Math.floor(a.length * Math.random()))] += 0.01;
                    sishewuru(a);
                }
                printArray(a);
                double sum3 = Math.round(sum(a) * 100);
                System.out.println("共发出：" + sum3 / 100 + "元");
                MaxNo = Max(a);
                MinNo = Min(a, cash);
                if (MaxNo == MinNo)
                    System.out.println("运气王不存在的");
                else {
                    System.out.println("运气王是" + MaxNo + "号dalao");
                }
        }
            else if (way == 3) {
            if (cash * 100 % num != 0) {
                System.out.println("金额不能平均分配给每个红包，程序结束");
            } else {
                a = putongArray(a, cash);// 普通红包，存入数组
                printArray(a);// 打印每个红包到屏幕
                double sum3 = Math.round(sum(a) * 100);
                System.out.println("总金额：" + sum3 / 100);
            }
        }
    }

    public static double[] initial(double[] a) {
        for (int i = 0; i <= a.length - 1; i++)
            a[i] = 0.01;
        return a;
    }


    public static void printArray(double[] a)// 方法：打印数组到屏幕
    {
        System.out.print("结果:" + "\n");
        for (int i = 0; i <= a.length - 1; i++)
            System.out.println("第" + (i + 1) + "个红包里面有" + a[i] + "元");
    }

    public static double[] baoliu(double[] a)// 保留两位小数，不要四舍五入
    {
        double b;
        double c;
        for (int i = 0; i < a.length; i++) {
            b = a[i];
            c = (Math.floor(100 * b));// 向下取整
            c /= 100;
            a[i] = c;
        }
        return a;
    }

    public static double[] arraygenerate(double[] a)// 产生随机数组
    {
        for (int i = 0; i <= a.length - 1; i++) {
            a[i] = Math.random();
            a = baoliu(a);
        }
        return a;
    }

    public static double[] pinshouqiArray(double[] a, double cash) {
        arraygenerate(a);// 随机给数组中的每个元素分配一个0～1之间的小数
        double sum;// 定义变量
        sum = sum(a);
        for (int i = 0; i <= a.length - 1; i++) {
            a[i] *= ((cash - a.length * 0.01) / sum);
            a[i] += 0.01;
        }
        baoliu(a);
        return a;// 返回数组
    }

    public static double[] sishewuru(double[] a)// 保留两位小数，四舍五入
    {
        double b;
        double c;
        for (int i = 0; i < a.length; i++) {
            b = a[i];
            c = Math.round(100 * b);// 向下取整
            c /= 100;
            a[i] = c;
        }
        return a;
    }

    /**
     * @param a
     * @return
     */
    public static double sum(double[] a) {
        double sum = 0;
        for (int i = 0; i <= a.length - 1; i++)
            sum += a[i];// 算出所有元素的总和
        return sum;
    }

    public static double[] putongArray(double[] a, double cash)// 普通红包
    {
        for (int i = 0; i <= a.length - 1; i++) {
            double temp;
            temp = Math.floor(cash * 10);// 向下取整，为避免系统自动四舍五入导致超额的情况
            temp /= 10;
            a[i] = temp / a.length;// 取平均值
        }
        return a;// 返回数组
    }

    public static int Max(double[] a)// 求最大值的序号
    {
        double max = 0;
        int recmax = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            if (a[i] > max) {
                max = a[i];
                recmax = i + 1;
            }
        }
        return recmax;// 返回最大值的序号
    }

    public static int Min(double[] a, double cash)// 求最小值的序号
    {
        double min = cash + 1;
        int recmin = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            if (a[i] < min) {
                min = a[i];
                recmin = i + 1;
            }

        }
        return recmin;// 返回最小值的序号
    }
}