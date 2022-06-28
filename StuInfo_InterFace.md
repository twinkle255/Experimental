# Experimental
实验报告 <br>

> 设计一个学生信息读取器，希望所设计的读取器可以展示学生的学号和名字,采用面向接口编程实现。<br>
> 其中：除了主类外， 还有学生类 Student 和三类学生<br>
> 即本科生（Undergraduate）、硕士生（Master Degree Candidate）和博士生（Doctoral Candidate）<br>
> 以及的学生信息读取器StuInfoReader 和大学（University）<br>
> 其中：大学负责学生相关信息的设定。

```Java
package Package_1;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class StuInfo_InterFace {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入预计要保存的本科生人数");
        Student[] UnderGraduate = new Undergraduate[reader.nextInt()];
        System.out.println("请输入预计要保存的硕士生人数");
        Student[] Master = new Master_Degree_Candidate[reader.nextInt()];
        System.out.println("请输入预计要保存的博士生人数");
        Student[] Doctor = new Doctoral_Candidate[reader.nextInt()];

        System.out.println("请输入本科生的信息");
        for (int i = 0; i < UnderGraduate.length; i++) {
            UnderGraduate[i] = new Undergraduate();
            UnderGraduate[i].setName(reader.next());
            UnderGraduate[i].setID(reader.nextLong());
        }
        System.out.println("请输入硕士生的信息");
        for (int i = 0; i < Master.length; i++) {
            Master[i] = new Master_Degree_Candidate();
            Master[i].setName(reader.next());
            Master[i].setID(reader.nextLong());
        }
        System.out.println("请输入博士生的信息");
        for (int i = 0; i < Doctor.length; i++) {
            Doctor[i] = new Doctoral_Candidate();
            Doctor[i].setName(reader.next());
            Doctor[i].setID(reader.nextLong());
        }

        StuInfoReader readInfo = new StuInfoReader();

        Undergraduate.showGrade();
        for (Student student : UnderGraduate) {
            readInfo.readMessage(student);
        }
        Master_Degree_Candidate.showGrade();
        for (Student student : Master) {
            readInfo.readMessage(student);
        }
        Doctoral_Candidate.showGrade();
        for (Student student : Doctor) {
            readInfo.readMessage(student);
        }
    }
}

interface Student {
    void setID(long ID);

    void setName(String Name);

    long getID();

    String getName();
}

class University implements Student {
    private long ID;
    private String name;

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public void setName(String Name) {
        this.name = Name;
    }

    @Override
    public long getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }
}


//本科生
class Undergraduate extends University {
    public static void showGrade() {
        System.out.println("本科生:");
    }
}

//硕士生
class Master_Degree_Candidate extends University {
    public static void showGrade() {
        System.out.println("硕士生:");
    }

}

//博士生
class Doctoral_Candidate extends University {
    public static void showGrade() {
        System.out.println("博士生：");
    }
}

class StuInfoReader {
    public void readMessage(@NotNull Student student) {
        System.out.print(student.getName() + "\t" + "|" + " ");
        System.out.print(student.getID() + "\n");
    }
}
```
