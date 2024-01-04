import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.FileManagement;

public class TestFileManagement {
    public FileManagement fileManager = new FileManagement();

    @Test
    public void testFileExists() {
        String fileName = "temp.txt";

        assertTrue(fileManager.checkIfFileExists(fileName));
    }

    @Test
    public void testFileNotExists() {
        String fileName = "test.txt";

        assertFalse(fileManager.checkIfFileExists(fileName));
    }

    @Test
    public void testDeleteFile() {
        String fileName = "toBeDeleted.txt";

        try {
            fileManager.deleteFile(fileName);

            assertTrue(true);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateDirectory() {
        String directoryName = "test";

        try {
            fileManager.createDirectory(directoryName);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateFile() {
        String fileName = "test2.java";

        try {
            fileManager.createFile(fileName);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testListAllFiles() {
        String directoryName = "";

        try {
            ArrayList<String> files = fileManager.getAllFiles(directoryName);

            assertEquals(new ArrayList<>(List.of(".git", "pom.xml", "src", "target")), files);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
