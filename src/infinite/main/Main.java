package infinite.main;


import infinite.main.task1.Dfs;
import infinite.main.task1.Node;
import infinite.main.task2.Numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Menu wyboru zadania
        System.out.print("---- Wybierz zadanie ---- \n 1 - DFS \n 2 - Ciąg liczbowy \n");
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                Dfs dfs = new Dfs();
                Node root = new Node(1);
                root.left = new Node(2);
                root.right = new Node(3);
                root.left.left = new Node(4);
                root.left.right = new Node(5);
                root.right.left = new Node(6);
                root.right.right = new Node(7);
                dfs.search(root);
                break;
            case 2:
                char[] separators = {',', '.', ';'};
                String numbersString = "12,34.56;67";
                Numbers numbers = new Numbers(separators);
                try {
                    System.out.println("Wynik końcowy: " + numbers.calculate(numbersString));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                throw new IllegalStateException("Wybór " + choose + " nie jest zdefiniowany!");
        }
    }
}