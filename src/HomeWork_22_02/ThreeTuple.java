package HomeWork_22_02;

public class ThreeTuple<A, B, C> {
    public A fisrt;
    public B second;
    public C third;

    public ThreeTuple(A fisrt, B second, C third) {
        this.fisrt = fisrt;
        this.second = second;
        this.third = third;
    }

    public ThreeTuple(A fisrt) {
        this.fisrt = fisrt;
    }
}
