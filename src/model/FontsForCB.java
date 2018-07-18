package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontsForCB {
    Font chinaCur = Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/ChinaCur.ttf"));
    Font deux = Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/DEUX.otf"));
    Font sanFrancisco = Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/SanFracisco.ttf"));
    Font zapfino = Font.createFont(Font.TRUETYPE_FONT, new File("src/model/resources/fonts/Zapfino.otf"));

    public FontsForCB() throws IOException, FontFormatException {
    }

    public String[] getFontsList(){
        String[] fonts = {chinaCur.getFontName(), deux.getFontName(), sanFrancisco.getFontName(),
                zapfino.getFontName()};

        return fonts;
    }
}
