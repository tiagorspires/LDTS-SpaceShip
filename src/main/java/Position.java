public class Position {
    private int x;
    private int y;

    public Position(int a,int b){
        x=a;
        y=b;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int a){
        this.x = a;
    }

    public void setY(int a){
        this.y = a;
    }

    public boolean equals(Position position){
        return this.x == position.x && this.y == position.y;
    }

}