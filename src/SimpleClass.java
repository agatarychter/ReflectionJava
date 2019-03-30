public class SimpleClass {
    int a;
    Pair pair;
    String s = "hello";

    public SimpleClass()
    {}

    /*

    w przypadku przeciążenia - make new instance sparametryzowane wybierze opcję
     */
//    public SimpleClass(Integer a, Pair pair)
//    {
//        this.a = 2*a;
//        this.pair = pair;
//    }

    public SimpleClass(int a, Pair pair)
    {
        this.a = a;
        this.pair = pair;
    }

    public SimpleClass(Pair pair)
    {
        this.pair = pair;
    }


    public String toString()
    {
        return "a: "+ a + " pair: " + pair;
    }
}
