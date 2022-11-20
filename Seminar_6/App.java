package Seminar_6;

class Goods {

    public int count;
    public String name;
    public double price;
    public StringBuilder description;

    class ProxyName {
        String val;

        public ProxyName(String v) {
            this.val = v != null ? v : "EMPTY";

            if (v != null)
                this.val = v;
            else
                this.val = "EMPTY";
        }

        public String getVal() {
            return val;
        }
    }

    public Goods(String name) {
        this.name = new ProxyName(name).getVal();
    }

    public class App {
        public static void main(String[] args) {
            Product Milk = new Product();

            Milk = new CreateProduct()
                    .setCount(1)
                    .setName("Молоко")
                    .setPrice(65.99)
                    .Create();

            Milk.print();
        }
    }
}
