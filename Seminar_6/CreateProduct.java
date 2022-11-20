package Seminar_6;

public class CreateProduct {
    Product temp;

    public CreateProduct() {
        temp = new Product();
        temp.count = -1;
        temp.description = "Описание отсутствует";
        temp.name = "Название товара не введено";
        temp.price = -1;
    }

    public CreateProduct setCount(int count) {
        temp.count = count;
        return this;
    }

    public CreateProduct setDescription(String description) {
        temp.description = description;
        return this;
    }

    public CreateProduct setName(String name) {
        temp.name = name;
        return this;
    }

    public CreateProduct setPrice(double price) {
        temp.price = price;
        return this;
    }

    public Product Create() {
        return temp;
    }

}
