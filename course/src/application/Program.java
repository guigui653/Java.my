package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Product Product = new Product();
        System.out.println("Enter product data:");
        System.out.println("nome do produto :");
        Product.name = sc.nextLine();
        System.out.println("preço do produto :");
        Product.price = sc.nextDouble();
        System.out.println("quantidade do produto :");
        Product.quantity = sc.nextInt();

        System.out.println();
        System.out.println("Product data: " + Product);

        System.out.println();
        System.out.println("Enter the number of products to be added in stock:");
        int addQuantity = sc.nextInt();
        Product.AddProduct(addQuantity);

        System.out.println();
        System.out.println("updated data: " + Product);

        System.out.println();
        System.out.println("Enter the number of products to be removed from stock:");
        int removeQuantity = sc.nextInt();

        
        sc.close();
    }
}
