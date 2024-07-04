package infinite.test.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import infinite.main.task1.Dfs;
import infinite.main.task1.Node;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DfsTest {

    @Test
    public void testDfsPreorder() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Dfs tree = new Dfs();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.dfsPreorder(root);

        String expectedOutput = "1, 2, 4, 5, 3, 6, 7";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDfsInorder() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Dfs tree = new Dfs();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.dfsInorder(root);

        String expectedOutput = "4, 2, 5, 1, 6, 3, 7";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDfsPostorder() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Dfs tree = new Dfs();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.dfsPostorder(root);

        String expectedOutput = "4, 5, 2, 6, 7, 3, 1";
        assertEquals(expectedOutput, outContent.toString());
    }
}
