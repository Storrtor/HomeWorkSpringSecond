package homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class  MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homework2");
        Cart cart = context.getBean(Cart.class);
        ProductService productService = context.getBean(ProductService.class);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            String[] splittedStr = str.split(" ");
            if (str.equals("/end")) {
                break;
            }
            if (str.startsWith("/show")) { // show
                System.out.println(cart);
            }
            if (str.startsWith("/add")) { //add 1
                System.out.println("Товер добавлен: ");
                cart.addProductById(Long.parseLong(splittedStr[1]));
            }
            if (str.startsWith("/rm")) { //rm 1
                long id = Long.parseLong(splittedStr[1]);
                System.out.println("Товер удален: " + productService.getTitleById(id));
                cart.removeProductById(id);
            }
        }
        context.close();
    }
}
