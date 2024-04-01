package uvg.edu.gt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Esta prueba unitaria crea un árbol binario de búsqueda con algunas palabras predefinidas
// y sus traducciones asociadas. Luego, verifica si las traducciones son correctas utilizando el método
// translateWord de la clase BinaryTree.

class DictionaryTranslatorTest {

    @Test
    void testTranslateWord() {
        BinaryTree dictionary = new BinaryTree();

        // Insertar algunas palabras en el diccionario de prueba
        dictionary.insert("hello", "hola");
        dictionary.insert("world", "mundo");
        dictionary.insert("apple", "manzana");

        // Traducir palabras y verificar las traducciones esperadas
        assertEquals("hola", dictionary.translateWord(dictionary.root, "hello"));
        assertEquals("mundo", dictionary.translateWord(dictionary.root, "world"));
        assertEquals("manzana", dictionary.translateWord(dictionary.root, "apple"));

        // Verificar que las palabras no encontradas devuelvan el asterisco alrededor de la palabra
        assertEquals("*unknown*", dictionary.translateWord(dictionary.root, "unknown"));
    }
}
