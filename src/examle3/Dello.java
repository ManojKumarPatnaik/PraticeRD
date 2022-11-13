package examle3;

public class Dello {
    protected  static  int m1()  {
        try {
            m2();
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        return  2;

    }

    private static void m2() throws Exception {
        System.out.println("jdb");
        throw  new Exception("fj");

    }

    public static void main(String[] args)  {
        System.out.println(m1());
    }
}
