package homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class  MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homework2");
        Cart cart = context.getBean(Cart.class);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            String[] splittedStr = str.split(" ");
            if (str.equals("/end")) {
                break;
            }
            if (str.startsWith("/show cart")) { // show cart
                System.out.println(cart);
            }
            if (str.startsWith("/add cart")) { //add cart 1
                System.out.println("Товер добавлен: ");
                cart.addProductById(Long.parseLong(splittedStr[2]));
            }
            if (str.startsWith("/rm cart")) { //rm cart 1
                System.out.println("Товер удален: ");
                cart.removeProductById(Long.parseLong(splittedStr[2]));
            }
        }
        context.close();
    }
}
