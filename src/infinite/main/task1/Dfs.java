package infinite.main.task1;

import java.util.Scanner;

public class Dfs {

    public void search(Node root) {
        Scanner scan = new Scanner(System.in);

        //Menu wybory sposobu przeszukiwania
        System.out.print("----Wybierz sposób przeszukiwania ---- \n 1 - Preorder \n 2 - Inorder \n 3 - Postorder \n");
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Preorder:");
                dfsPreorder(root);
                break;
            case 2:
                System.out.println("Inorder:");
                dfsInorder(root);
                break;
            case 3:
                System.out.println("Postorder:");
                dfsPostorder(root);
                break;
            default:
                throw new IllegalStateException("Niezdefiniowana wartość: " + choose);
        }
    }

    //Funkcje wyszukiwania
    public void dfsPreorder(Node node) {
        StringBuilder result = new StringBuilder();
        dfsPreorderHelper(node, result);
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        System.out.print(result);
    }

    private void dfsPreorderHelper(Node node, StringBuilder result) {
        if (node != null) {
            result.append(node.value).append(", ");
            dfsPreorderHelper(node.left, result);
            dfsPreorderHelper(node.right, result);
        }
    }



    public void dfsInorder(Node node) {
        StringBuilder result = new StringBuilder();
        dfsInorderHelper(node, result);
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        System.out.print(result);
    }

    private void dfsInorderHelper(Node node, StringBuilder result) {
        if (node != null) {
            dfsInorderHelper(node.left, result);
            result.append(node.value).append(", ");
            dfsInorderHelper(node.right, result);
        }
    }

    public void dfsPostorder(Node node) {
        StringBuilder result = new StringBuilder();
        dfsPostorderHelper(node, result);
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        System.out.print(result);
    }

    private void dfsPostorderHelper(Node node, StringBuilder result) {
        if (node != null) {
            dfsPostorderHelper(node.left, result);
            dfsPostorderHelper(node.right, result);
            result.append(node.value).append(", ");
        }
    }
}
