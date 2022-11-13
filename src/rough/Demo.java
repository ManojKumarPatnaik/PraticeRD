package rough;

import java.util.*;
import java.util.stream.Stream;


public class Demo {
    public static void main(String[] args) {
       /* long maxValue=Long.MAX_VALUE;
        System.out.println(maxValue);*/

        int[][] array={{36,3},{1,5},{12,8},{25,9},{53,11},{29,12},{52,14}};
//        Arrays.stream(array).distinct().forEach(System.out::println);
//        var mp=new HashMap<Integer,Integer>();
//        mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey();
        var pq=new PriorityQueue<Pair>((i1,i2)->i2.getB() -i1.getB()==0?i1.getA()-i2.getA():i2.getB()-i1.getB());
        int[] nums={1,2,3,4};
        List<Integer> integerList = Arrays.stream(nums).boxed().filter(i -> i % 2 == 0 && i % 3 == 0).toList();
//        Arrays.stream(array).
        integerList.size();


        int s=0;
        for(var v:array){
           pq.offer( new Pair(v[0],v[1]-s));
           s=v[1];
        }
        System.out.println(pq);
        System.out.println(Objects.requireNonNull(pq.poll()).getA().intValue());

    }

    static class Pair{
        private Integer a;

        public Integer getA() {
            return this.a;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        public Integer getB() {
            return b;
        }

        private Integer b;

        public  Pair(Integer a,Integer b){
            this.a=a;
            this.b=b;
        }

    }

}

