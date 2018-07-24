package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontsForCB {
    private Font chinaCur =
            Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/ChinaCur.ttf"));
    private Font deux =
            Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/DEUX.otf"));
    private Font sanFrancisco =
            Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/SanFracisco.ttf"));
    private Font zapfino =
            Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/Zapfino.otf"));

    public FontsForCB() throws IOException, FontFormatException {
    }

    public String[] getFontsList(){

        return new String[]{chinaCur.getFontName(), deux.getFontName(), sanFrancisco.getFontName(),
                zapfino.getFontName()};
    }
}
