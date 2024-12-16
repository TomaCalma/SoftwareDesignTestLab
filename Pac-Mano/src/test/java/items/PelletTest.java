package items;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class PelletTest {
    @Test
    void pellet(){
      Pellet pellet = new Pellet(0,0);
      TextGraphics textGraphics = Mockito.mock(TextGraphics.class);

      pellet.draw(textGraphics);
      Assertions.assertTrue(pellet.visible);
      Assertions.assertEquals(10,pellet.points);
    }

    @Test
    void powerpellet(){
        Pellet pellet = new PowerPellet(0,0);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);

        pellet.draw(textGraphics);
        Assertions.assertTrue(pellet.visible);
        Assertions.assertEquals(50,pellet.points);
    }
}
