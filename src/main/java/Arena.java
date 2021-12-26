import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private static int height;
    private static int width;
    private static Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;


    public Arena(int height,int width){
        this.height = height;
        this.width = width;
        hero = new Hero(10,10);
        this.walls = createWalls();
        this.coins = createCoins();
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    public boolean canHeroMove(Position position){
        if(position.getX()<width-1  && position.getX()>0 && position.getY()<height-1 && position.getY()>0)
            return true;
        return false;
    }

    public void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default:
                System.out.println("INVALID KEY" + key);
        }
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; c++){
            walls.add(new Wall(c,0));
            walls.add(new Wall(c,height -1));
        }

        for(int r = 1; r < height; r++){
            walls.add(new Wall(0,r));
            walls.add(new Wall(width -1,r));
        }

        return walls;
    }

    public void draw(Screen screen) throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for(Wall wall: walls)
            wall.draw(graphics);
        for(Coin coin: coins)
            coin.draw(graphics);
        hero.draw(screen, graphics);
        hasScored();
        screen.refresh();
    }

    public void hasScored(){
        for(Coin coin: coins){
            if(hero.getPosition().equals(coin.getPosition()))
                coins.remove(coin);
        }
    }
}