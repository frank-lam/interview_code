package interview.code_0913_vivo;

import java.util.*;

public class UsingArrayList {
    public static void main(String[] args){
        int elementIndex = 1;
        Scanner inputElement = new Scanner(System.in);
        ArrayList elementlist = new ArrayList();
        boolean inputOver = false;
        System.out.printf("请任意输入N行N个字符串\n");
        System.out.printf("当输入inputOver时结束\n");

        do {
            System.out.printf("输入第" + elementIndex + "个字符串\n");
            System.out.printf(">>");
            String input = inputElement.nextLine();
            if (input.equals("inputOver")){
                inputOver = true;
                System.out.println("输入完毕！");
            }
            else {
                elementlist.add(input);
                elementIndex++;
            }
        }while (inputOver == false);      //用do-while语句加上if判断来控制输入N行夹杂数字大小写的字符串



        elementIndex = elementIndex - 1;
        System.out.printf("排序前:\n");
        String[] newArray = new String[elementIndex];
        for (int k=0;k <elementIndex;k++)
            System.out.printf(">> " + elementlist.get(k) + "\n");
        for (int index=0;index <elementIndex;index++)
            newArray[index] = elementlist.get(index).toString();
        for (int i=0;i <elementIndex;i++)
            newArray[i] = newArray[i].replaceAll("\\d+","");
        for (String element : newArray)
            System.out.printf(element +"\n");
        System.out.println("排序后\n");
        for (int listIndex=0;listIndex <newArray.length;listIndex++){
            sortArrays(listIndex,newArray);
        }

    }


    public static void sortArrays(int number,String[] newArray){
        String[] sortArray = new String[newArray[number].length()];
        for(int k=0;k<newArray[number].length();k++){
            sortArray[k] = newArray[number].substring(k,k+1);
        }
        Arrays.sort(sortArray,String.CASE_INSENSITIVE_ORDER);
        String finalString = ">>";
        for (int j=0;j<sortArray.length;j++){
            finalString = finalString.concat(sortArray[j]);
        }
        System.out.println(finalString);
    }

}