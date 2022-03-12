package lambdasinaction.chap1.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringRepeatElemetes {

    //将重复的数据取出来,有几种方法
    private static List elems = Arrays.asList("b","e","d","c","b","a","a","c","b","a");

    public static void main(String ... args) {

        long start = System.currentTimeMillis();
        List<String> repeatList = filterRepeat(elems,new PredicateRepeatElement<String>());
        System.out.println(repeatList.toString());
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }


    public static List<String> filterRepeat(List<String> elems, Predicate<String> p){
        return elems.stream().filter(e-> p.test(e)).collect(Collectors.toList());
    }

    private static class PredicateRepeatElement<T> implements Predicate<String> {
        private Set<String> hashSet = new HashSet<>();


        @Override
        public boolean test(String s) {
            if (hashSet.contains(s)){
                return true;
            }else {
                hashSet.add(s);
                return false;
            }
        }
    }
}
