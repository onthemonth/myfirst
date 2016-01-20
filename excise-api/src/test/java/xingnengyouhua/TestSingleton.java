package xingnengyouhua;

/**
 * Created by mgq on 2015/12/9.
 */
public class TestSingleton {
    //缺点：不能延迟加载

    //私有构造方法
    private TestSingleton(){
        System.out.println("测试不能延迟加载，构造方法");
    }
    //在类加载的时候就创建对象
    private static TestSingleton testSingleton=new TestSingleton();
    public static TestSingleton getInstance(){
        return testSingleton;
    }
    //解释为什么不能延迟加载
    public static void createString(){
        System.out.println("测试不能延迟加载");
    }

}
class TestLazy{
    public static void main(String[] args){
        //如果我只想执行createString的话，会把类中所有的静态初始化
        TestSingleton.createString();
    }
}

