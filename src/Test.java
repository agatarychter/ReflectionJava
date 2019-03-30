import java.util.Arrays;

public class Test {
    public static void main (String[] args) {
//        SimpleClass simpleClass = GenericManagerClass.makeNewInstance(SimpleClass.class);
//        System.out.println(simpleClass);
//
//        String string = GenericManagerClass.makeNewInstance(String.class);
//        if(string != null)
//        {
//            System.out.println("not null");
//        }
//        System.out.println(Arrays.toString(GenericManagerClass.createArray(String.class, 5)));
//        System.out.println(Arrays.toString(GenericManagerClass.createArray(SimpleClass.class, 10)));
//
//        SimpleClass simpleClass1 = new SimpleClass();
//        Pair<SimpleClass> pair = new Pair<>(simpleClass, simpleClass1);
//        Pair<SimpleClass> pair2 = GenericManagerClass.clone(pair, Pair.class);
//        System.out.println(pair2.getSecond().a);
//        simpleClass1.a = 2;
//        System.out.println(pair.getSecond().a);
//        System.out.println(pair2.getSecond().a);
//
//        pair.first = simpleClass1;
//        System.out.println(pair.getFirst());
//        System.out.println(pair2.getFirst());
//
//        String s = "g";
//        String g = GenericManagerClass.clone(s, String.class);
//        System.out.println("Cloned String: " + g);
////
//        Integer j = GenericManagerClass.makeNewInstance(Integer.class, "5");
//        System.out.println(j);
//        Object [] arg = {5, new Pair<SimpleClass>()};
//        SimpleClass sc = GenericManagerClass.makeNewInstance(SimpleClass.class,5,pair);
////        System.out.println(sc.toString());
        Double d = GenericManagerClass.makeNewInstance(Double.class, 1.0);
        System.out.println(d);

        SimpleClass simpleClass = GenericManagerClass.makeNewInstance(SimpleClass.class);
        System.out.println(simpleClass);

        SimpleClass simpleClassPair = GenericManagerClass.makeNewInstance(SimpleClass.class, new Pair<Integer>());
        System.out.println(simpleClassPair);

        SimpleClass simpleClassIntPair = GenericManagerClass.makeNewInstance(SimpleClass.class, 10, new Pair<Integer>());
        System.out.println(simpleClassIntPair.a);


        System.out.println(Arrays.toString(GenericManagerClass.createArray(String.class, 5)));
        System.out.println(Arrays.toString(GenericManagerClass.createArray(SimpleClass.class, 10)));

        String[] strings = GenericManagerClass.createArray(String.class,5);
        strings[0] = "hello";
        System.out.println("Strings[0] " + strings[0]);

        Pair<Integer> pair = new Pair<>();
        Pair<String> stringPair = GenericManagerClass.makeNewInstance(Pair.class);
        System.out.println(pair+ ", " +  stringPair);

        pair.first = 5;
        pair.second = 10;

        Pair clonedPair = GenericManagerClass.clone(pair, Pair.class);
        System.out.println(clonedPair);
        System.out.println(pair.first);
        System.out.println(clonedPair.first);

        pair.first = 12;
        System.out.println(pair.first);
        System.out.println(clonedPair.first);

        Pair<SimpleClass> referencePair = new Pair<>(simpleClass, simpleClassPair);
        System.out.println(referencePair.first);

        Pair<SimpleClass> clonedReferencePair = GenericManagerClass.clone(referencePair,Pair.class);
        System.out.println(clonedReferencePair.first);

        referencePair.first.a = 10;


        SimpleClass simpleClassCloned = GenericManagerClass.clone(simpleClass,SimpleClass.class);
        System.out.println(simpleClass.s);
        simpleClass.s = "changed";
        System.out.println(simpleClass.s);
        System.out.println(simpleClassCloned.s);

    }
}
