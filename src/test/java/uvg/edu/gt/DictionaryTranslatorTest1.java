package uvg.edu.gt;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
// Esta prueba unitaria intenta leer el archivo de texto "texto.txt" y verifica si el contenido leído no está vacío. Esto verifica si el programa puede acceder y leer correctamente el archivo de texto.
// Asegúrate de ajustar la ruta del archivo "texto.txt" cambiando la ruta del archivo en String filePath = "(Poner la raiz) ".
public class DictionaryTranslatorTest1 {

    @Test
    void testReadTextFile() {
        String filePath = "C:\\Users\\gabri\\IdeaProjects\\HDT7\\src\\main\\java\\uvg\\edu\\gt\\texto.txt"; // Ruta del archivo de texto

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verificar que el contenido leído no esté vacío
        assertFalse(content.toString().isEmpty());
    }
}
