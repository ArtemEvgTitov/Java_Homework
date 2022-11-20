package Seminar_6;

public class Products {
    public int count;
    public String name;
    public double price;
    public StringBuilder description;

    public void print() {
        System.out.println(
                String.format(
                        "%d %s %d %s",
                        this.count,
                        this.name,
                        this.price,
                        this.description));
    }
}
