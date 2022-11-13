package Example2;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        int n = 153;
        A a= (A) new B();
        a.foo();


        System.out.println("Hello world!");
    }
}
class  AccountServiceForSRP{ //Example2.A class should have one and only one reason to change
    public static void accountOpening(){
        System.out.printf("filling the form");
        System.out.printf("store acc details in db");
        System.out.printf("Send notify");
        var v=new TreeSet<Integer>();
        v.add(1);


    }
}
//o- objects and entities should be open for extension and closed for modification

interface A{
    public void foo();
}
class B{
    public void foo(){
        System.out.println("foo");
    }
    public void foo(int d){
        System.out.printf("hdh");
    }
}