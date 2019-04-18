package PointAtOffer;

/**
 * Singleton Pattern
 * Definition: Special class that can be instantiated only once, yield a single object
 * Application: Config object in Web application
 * 分类：饿汉式，懒汉式，双检锁，static inner class, enumeration
 * Evaluation: singleton, thread safety, lazy loading, avoid deserialization as new object, avoid inversion attack
 * 实现方法的选择：一般情况下直接使用饿汉式就好了，要求延迟加载时倾向于用静态内部类，涉及到反序列化创建对象或反射问题最好选择枚举
 */
public class Q02_Singleton {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton5 singleton5 = Singleton5.getInstance();
        Singleton6 singleton6 = Singleton6.getInstance();
        Singleton7 singleton7 = Singleton7.instance;
        singleton7.setAttribute("aaa");
    }
}

/**
 * Thread-safe, but allocate memory before usage
 */
class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    /**
     * You may also declare {@code instance} as public
     */
    public static Singleton1 getInstance() {
        return instance;
    }
}

/**
 * Thread-unsafe, but allocate memory when needed
 */
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * Thread-safe version of {@code Singleton2}, but synchronized would lead to blocking
 */
class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * Basically the same of {@code Singleton3}
 */
class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        synchronized (Singleton4.class) {
            if (instance == null) {
                instance = new Singleton4();
            }
        }
        return instance;
    }
}

/**
 * Double-checked Locking: Thread-safe, lazily-loading, lock only at first instantiation
 */
class Singleton5 {

    private volatile static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}

/**
 * Thread-safe (final), Lazily-loading via static inner class
 */
class Singleton6 {

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return Singleton6Holder.instance;
    }

    static class Singleton6Holder {
        public static final Singleton6 instance = new Singleton6();
    }
}

enum Singleton7 {

    instance;
    private String attribute;

    void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    String getAttribute() {
        return this.attribute;
    }
}
