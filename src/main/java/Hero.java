import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private Position position;

    public Hero(int x, int y){
        this.setPosition(new Position(x,y));
    }

    void setPosition(Position position){
        this.position = position;
    }


    public Position moveUp(){return new Position(this.getPosition().getX(), this.getPosition().getY() -1);}

    public Position moveDown(){return new Position(this.getPosition().getX(), this.getPosition().getY() +1);}

    public Position moveLeft(){return new Position(this.getPosition().getX() -1, this.getPosition().getY());}

    public Position moveRight(){return new Position(this.getPosition().getX() +1 , this.getPosition().getY());}


    public void draw(Screen screen, TextGraphics graphics) throws IOException {
        //screen.clear();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "X");
    }

    public Position getPosition() {
        return position;
    }
}