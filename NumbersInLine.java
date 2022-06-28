package Experimental_Report04;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NumbersInLine {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner reader = new Scanner(System.in);
        Text text = new Text();
        //读取文本模块
        while (reader.hasNextLine()) {
            //输入文本
            text.InputText(reader.nextLine());
            //判断是否已经输入了十行文本
            if (text.text.size() == 10) {
                break;//跳出循环
            }
        }

        //为文本的每一行创建一个对象数组
        Sentence[] line = new Sentence[text.text.size()];
        //实例化对象
        Words words = new Words();
        Number[] num;

        for (int i = 0; i < line.length; i++) {
            line[i] = new Sentence();
            //将文本每一行进行分割
            line[i].DivideText(text, i);
            //将每i行的单词分割出来
            words.DivideLine(line[i]);
            //为每个单词分配内存
            num = new Number[words.word.length];
            //将所有的数组替换为“#”，方便以后使用
            String newLineOne = line[i].getLine().replaceAll("\\d+", "#");
            //分割出每个单词的数字
            for (int j = 0; j < words.word.length; j++) {
                num[j] = new Number();
                //挑出数字并储存他们
                num[j].selectNumber(words, j);
                //输出
                System.out.print("第" + (i + 1) + "行文本第" + (j + 1) + "个单词包含的数字有：");
                num[j].showNumbers();
                //数字加随机数模块
                for (int k = 0; k < num[j].numbers.length; k++) {
                    //剔除数组空元素，避免出错
                    if (!Objects.equals(num[j].numbers[k], "")) {
                        //String类型的原数字转化为int类型数字
                        int i1 = Integer.parseInt(num[j].numbers[k], 10);
                        //生成随机数
                        int i2 = r.nextInt(100) + 1;
                        //数字加上随机数
                        String i3 = String.valueOf(i1 + i2);
                        //替换
                        newLineOne = newLineOne.replaceFirst("#", i3);
                    }
                }
            }
            //输出替换过的文本
            System.out.println("替换过数字后的文本是：" + newLineOne + "\n");
        }


    }
}

class Text {
    //创建文章需要的存储空间
    protected List<String> text = new ArrayList<>();

    //读入文本
    public void InputText(String essay) {
        text.add(essay);
    }

    //获得相应文本对应行数
    public String getLineInText(int Ordinal) {
        return this.text.get(Ordinal);
    }

}

class Sentence extends Text {
    protected String line;//文章中的每一行

    //分割文本的每一行
    public void DivideText(@NotNull Text text, int index) {
        this.line = text.getLineInText(index);
    }

    public String getLine() {
        return line;
    }
}

class Words extends Sentence {
    protected String[] word;

    //分割每一行中的单词
    public void DivideLine(@NotNull Sentence line) {
        this.word = line.getLine().split("\\s+");
    }

}

class Number extends Words {
    protected String[] numbers;

    //选出每个单词中的数字，并将其存入数组
    public void selectNumber(@NotNull Words word, int index) {
        this.numbers = word.word[index].split("(\\D+)");
    }

    //输出数字
    public void showNumbers() {
        for (String number : numbers) {
            //判断数组是否为空，格式化输出
            if (!Objects.equals(number, "")) {
                System.out.print(number + "\t");
            }
        }
        System.out.println();
    }
}