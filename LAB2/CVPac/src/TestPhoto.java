package CVPac;

import CVPac.Photo;
import java.io.*;
import java.util.Random;

public class TestPhoto {
        @org.junit.Test
        public void writeHTML() throws Exception {

            String imageUrl = "jan-kowalski.png";
            // Utwórz strumień zapisujący w pamięci
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(os);
            // Utwórz obiekt i zapisz do strumienia
            new Photo(imageUrl).writeHTML(ps);
            String result = null;
            // Pobierz jako String
            try {
                result = os.toString("ISO-8859-2");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //System.out.println(result);

            // Sprawdź, czy result zawiera wybrane elementy
            assert(result.contains("<img"));
            assert(result.contains("/>"));
            assert(result.contains("src="));
            assert(result.contains(imageUrl));

        }

    }
