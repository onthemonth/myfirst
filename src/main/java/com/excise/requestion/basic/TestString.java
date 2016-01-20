package com.excise.requestion.basic;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * Created by mgq on 2016/1/5.
 */
public class TestString {
    public static final String ss="111";
    /*
    * String s = "hello world!" 会先在堆内存中分配一段空间，new一个字符串对象，然后s指向这个对象；在jdk1.6中String subStr = s.substring(1,2);会把subStr变量指向“hello world！”对象中的“e”，而不是重新新建一个对新，而JDK1.7中会创建一个新的字符串对象，这就是JDK1.7对这个方法的优化。

      可能有人要吐槽，这尼玛也叫优化。现在来想这个问题，如果现在有一个很长的字符串，只需要用的字符串当中的很少的一段，用substring截取需要的字符串之后，在jdk1.6中,因为有subStr对象指向它,字符串依然存在在内存中，而在1.7中，新创建了一个字符串，s这个变量如果在后面的程序已经没在使用过，垃圾回收机制会自动回收s和s指向的对象。

      但现在依然运行在jdk1.6以及以前版本的jdk上的程序该怎么办，一个比较简单的方法是使用substring方法的时候可以在后面加一个空字符串，就像：String subStr = s.substring(1,2)+""；这样subStr会指向新的String对象，原来的字符串就让它自生自灭吧。

      可以查看jdk6和jdk7的源码：
      6的subString()调用：
      String(int offset,int count,char value[]){
        this.value=value;
        this.offset=offset;
        this.count=count;
      }
      7的subString()调用：
      public String(char value[], int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }
        // Note: offset or count might be near -1>>>1.
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset+count);
    }
    对上面解释的补充：
    楼主说的有些道理，但是不全对吧。jdk6,7中String的生命周期是一样的，只是 String中的char[]生命周期不一样。楼主可以看看jdk原代码。jdk6，7，是subString 都是new 的String().区别在于，jdk6把原String的 char[]引用给了 subString,而JDK7是 copy一份新的char[](指定长度的)。所以在jdk6,7中的区别是 char[]的生命周期不一样，并不是 String的生命周期不一样。
    *
    *
    *
    * */
    public static void main(String[] args){
        String s=new String("sssss");
        s.substring(1,2);
        char[] c=new char[]{'s','好',3,4};
        String ss=new String(c,1,3);
        System.out.println(ss);
        ss.substring(1,2);
    }

    @Test
    public void testSplit(){//字符串切割
        /*String split="abcd;d.k/";
        String [] args=split.split("[;|.|/]");
        String zuhe=new String();
        for (int i=0;i<args.length;i++){
            zuhe+=args[i];
        }
        System.out.println(zuhe);*/
        String orgStr=null;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<10000;i++){
            sb.append(i);
            sb.append(";");
        }
        orgStr=sb.toString();
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        for (int p=0;p<10000;p++) {
            String[] strings = orgStr.split(";");
            StringBuffer sb2 = new StringBuffer();
            for (int i = 0; i < strings.length; i++) {
                sb2.append(strings[i]);
            }
        }
        long endMili=System.currentTimeMillis();
        System.out.println(endMili - startMili + "毫秒");
        //System.out.println(sb2.toString());
    }
    @Test
    public void testStringTokenizer(){//StringTokenizer是jdk专门用来处理字符串分割子串的工具类
        String orgStr=null;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<10000;i++){
            sb.append(i);
            sb.append(";");
        }
        orgStr=sb.toString();
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        for (int p=0;p<10000;p++) {
            StringTokenizer st = new StringTokenizer(orgStr, ";");
            StringBuffer sb2 = new StringBuffer();
            while (st.hasMoreElements()) {
                sb2.append(st.nextToken());
                //System.out.println(st.nextElement());
            }
        }
        long endMili=System.currentTimeMillis();
        System.out.println(endMili-startMili+"毫秒");
        //System.out.println(sb2.toString());
    }

    @Test
    public void testIndexOfUnitSubString(){//测试indexOf联合SubString实现字符串切割
        String orgStr;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<10000;i++){
            sb.append(i);
            sb.append(";");
        }
        orgStr=sb.toString();
        int length=orgStr.length();
        StringBuffer ss=new StringBuffer();
        String splitStr=null;
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        //for(int i=0;i<length;i++){
        while (true) {
            int j = orgStr.indexOf(";");
            if (j < 0)
                break;
            splitStr = orgStr.substring(0, j);
            ss.append(splitStr);
            orgStr = orgStr.substring(j + 1);
        }
        //}
        long endMili=System.currentTimeMillis();
        System.out.println(endMili-startMili+"毫秒");
        //System.out.println(ss.toString());
    }
    @Test
    public void testCharAt(){//charAt(int index)返回给定字符串中，位置在index的字符
        String orgStr;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<10000;i++){
            sb.append(i);
            sb.append(";");
        }
        orgStr=sb.toString();
        //判断上面字符串是否已ABC开头或结尾，两种方式，1：charAt  2:startWith  endWith
        //1
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        int len=orgStr.length();
        for (int j=0;j<1000000;j++){//8毫秒
            if (orgStr.charAt(0)=='A' && orgStr.charAt(1)=='B' && orgStr.charAt(2)=='C'){
                if (orgStr.charAt(len-1)=='A' && orgStr.charAt(len-2)=='B' && orgStr.charAt(len-3)=='C'){

                }
            }
        }
        //2
        /*for (int k=0;k<1000000;k++){11毫秒
            orgStr.startsWith("ABC");
            orgStr.endsWith("ABC");
        }*/
        long endMili=System.currentTimeMillis();
        System.out.println(endMili-startMili+"毫秒");
    }
    @Test
    public void testStringBuilderAndConcatAndString(){//校验String串，stringbuilder和concat比较
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        //1:string 拼接
        String str=new String();//477毫秒
        /*for (int i=0;i<10000;i++){
            str=str+i;
        }*/
        //2:concat 拼接
        /*for (int i=0;i<10000;i++){//217毫秒
            str=str.concat(String.valueOf(i));
        }*/
        //System.out.println(str);
        //3:StringBuilder 拼接
        StringBuilder sb=new StringBuilder();//5毫秒
        for (int i=0;i<10000;i++){
            sb.append(i);
        }
        long endMili=System.currentTimeMillis();
        System.out.println(endMili-startMili+"毫秒");
    }
    @Test
    public void testStringBuilderAndStringBuffer(){//校验StringBuilder  StringBuffer
        //StringBuilder效率更高，但是方法不是同步的，无法保证线程安全。
        //StringBuffer效率比StringBuilder差一些，但是是线程安全的

    }
}