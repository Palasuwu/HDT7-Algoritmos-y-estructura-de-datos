package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TreeNode {
    String key;
    String value;
    TreeNode left, right;

    public TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(String key, String value) {
        root = insertRec(root, key, value);
    }

    TreeNode insertRec(TreeNode root, String key, String value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return root;
        }
        if (key.compareTo(root.key) < 0)
            root.left = insertRec(root.left, key, value);
        else if (key.compareTo(root.key) > 0)
            root.right = insertRec(root.right, key, value);
        else
            root.value = value;
        return root;
    }

    void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print("(" + root.key + ", " + root.value + ") ");
            inorderTraversal(root.right);
        }
    }

    String translateWord(TreeNode root, String word) {
        TreeNode current = root;
        while (current != null) {
            if (word.compareToIgnoreCase(current.key) < 0)
                current = current.left;
            else if (word.compareToIgnoreCase(current.key) > 0)
                current = current.right;
            else
                return current.value;
        }
        return "*" + word + "*";
    }
}

public class DictionaryTranslator {
    public static void main(String[] args) {
        BinaryTree dictionary = new BinaryTree();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gabri\\IdeaProjects\\HDT7\\src\\main\\java\\uvg\\edu\\gt\\diccionario.txt"));// Introducir la direccion del archivo del diccionario .txt
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.substring(1, line.length() - 1).split(", ");
                    dictionary.insert(parts[0].trim(), parts[1].trim());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("En orden recorrido :");
        dictionary.inorderTraversal(dictionary.root);
        System.out.println();

        System.out.println("\nTexto Traducido :");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gabri\\IdeaProjects\\HDT7\\src\\main\\java\\uvg\\edu\\gt\\texto.txt"));// Ingresar la direccion del archivo texto.txt
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        System.out.print(dictionary.translateWord(dictionary.root, word.toLowerCase()) + " ");
                    }
                    System.out.println();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
