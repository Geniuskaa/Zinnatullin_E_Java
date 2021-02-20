package HomeWork_22_02;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public D four;

    public FourTuple(A fisrt, B second, C third, D four) {
        super(fisrt, second, third);
        this.four = four;
    }
}
