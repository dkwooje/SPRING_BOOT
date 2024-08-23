package practice.semo;

class Test {
    String name = "kim";

    void hello() {
        System.out.println("안녕");
    }
}

class Friend {
    Friend() {
        String name = "park";
        int age = 20;
        System.out.println(name);
        System.out.println(age);
    }
    Friend(String a) {
        System.out.println(a);
    }
}

public class study2 {
    public static void main(String[] args) {

        Test test = new Test();
        test.hello();
        System.out.println();
        Friend F = new Friend("LEE");
        System.out.println();
        Friend D = new Friend();

    }



  }