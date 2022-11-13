package rough.coding;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] A = {1,2,4};
        System.out.println(subSets(A));
    }
    static  List<List<Integer>> subSets(int[] A){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for( var v: A){
            int n = ans.size();
            for (int i = 0; i < n; i++) {
                var internal = new ArrayList<Integer>(ans.get(i));
                internal.add(v);
                ans.add(internal);
            }
        }

        return  ans;
    }
}
