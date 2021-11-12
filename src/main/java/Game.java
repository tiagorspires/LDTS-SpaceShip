import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.ArrowRight;
import static com.googlecode.lanterna.input.KeyType.ArrowUp;
import static com.googlecode.lanterna.input.KeyType.ArrowDown;
import static com.googlecode.lanterna.input.KeyType.ArrowLeft;
import static com.googlecode.lanterna.input.KeyType.*;
public class Game {
    private static Screen screen;
    private int x = 10;
    private int y = 10;
    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }
    private void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()){
            case ArrowUp:
                y++;
            case ArrowDown:
                y--;
            case Character:
                break;
            case Escape:
                break;
            case Backspace:
                break;
            case ArrowLeft:
                x--;
            case ArrowRight:
                x++;
            case Insert:
                break;
            case Delete:
                break;
            case Home:
                break;
            case End:
                break;
            case PageUp:
                break;
            case PageDown:
                break;
            case Tab:
                break;
            case ReverseTab:
                break;
            case Enter:
                break;
            case F1:
                break;
            case F2:
                break;
            case F3:
                break;
            case F4:
                break;
            case F5:
                break;
            case F6:
                break;
            case F7:
                break;
            case F8:
                break;
            case F9:
                break;
            case F10:
                break;
            case F11:
                break;
            case F12:
                break;
            case F13:
                break;
            case F14:
                break;
            case F15:
                break;
            case F16:
                break;
            case F17:
                break;
            case F18:
                break;
            case F19:
                break;
            case Unknown:
                break;
            case CursorLocation:
                break;
            case MouseEvent:
                break;
            case EOF:
                break;
        }

    }

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            // resize screen if necessary
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
