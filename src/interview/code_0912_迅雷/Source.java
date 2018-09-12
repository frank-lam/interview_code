package interview.code_0912_迅雷;// 想到3 4 5; 4 3 5; 5 4 3; 其实是一样的所以有了一下的推理过程

// 递推过程

// 1 1 2; 1 1 3 ... 1 1 100;

// 1 2 3; 1 2 4 ... 1 2 100;

// 1 99 100;

// 2 2 3; 2 2 4 ... 2 2 100;

// 99 99 100;

public class Source {

    public static void main(String[] args) {

        Gougu.getGouguNum(100);

    }

}

// 勾股数的使用

class Gougu {

    // 通过递推来查找勾股数

    public static final void getGouguNum(int maxnum) {
        for (int i = 1; i < maxnum; i++) {
            for (int j = i; j < maxnum; j++) {
                for (int n = j + 1; n < maxnum; n++) {
                    if ((i * i + j * j) == n * n) {
                        System.out.println(" " + i + " " + j + " " + n);
                    }
                }
            }
        }
    }
}