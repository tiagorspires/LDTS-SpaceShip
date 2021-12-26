import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
//import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

//import javax.swing.*;
import java.io.IOException;

//import static com.googlecode.lanterna.input.KeyType.*;

public class Game {
    private static Screen screen;
    //private static Hero hero;
    private static Arena arena;
    //private int x;
    //private int y;

    public Game(){
        try {

            TerminalSize terminalSize = new TerminalSize(40,20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen((terminal));
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key){

    }

    /*private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x,y,TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
      }*/

    public void run(){

        arena = new Arena(20,40);
        while(true) {
            try {
                arena.draw(screen);
                KeyStroke key = screen.readInput();
                arena.processKey(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}