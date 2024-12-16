package items;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class PelletGroupTest {
    @Test
    void create(){
        PelletGroup pelletGroup = new PelletGroup();
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);

        pelletGroup.draw(textGraphics);

        Assertions.assertEquals(0,pelletGroup.numEaten);
        Assertions.assertEquals(10,pelletGroup.pelletList.get(0).points);
    }
}
