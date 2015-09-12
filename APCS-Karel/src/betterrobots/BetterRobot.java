package betterrobots;

import kareltherobot.*;

public class BetterRobot extends Robot {
    private int x = 0;
    private int y = 0;
    
    public BetterRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
        y = street;
        x = avenue;
    }

    public void moveTo(int fx, int fy) {
        goToLocation(fx, fy, false);
    }
    
    public void drawLine(int fx, int fy) {
        goToLocation(fx, fy, true);
    }
    
    public void drawLine(int sx, int sy, int fx, int fy) {
        moveTo(sx, sy);
        drawLine(fx, fy);
    }
    
    public void turnTo(int dir) {
        while (dir != getDirection()) {
            turnLeft();
        }
    }
    
    public int getDirection() {
        if (facingNorth()) {
            return 0;
        } else if (facingEast()) {
            return 1;
        } else if (facingSouth()) {
            return 2;
        } else if (facingWest()) {
            return 3;
        } else {
            return -1;
        }
    }
    
    public void move(int i) {
        for (; i > 0; i--) {
            move();
        }
    }
    
    public void move() {
        super.move();
        y += ((getDirection() % 2) - 1) * (getDirection() - 1) ;
        x += (getDirection() % 2) * (getDirection() - 2) * -1;
    }
    
    protected void goToLocation(int fx, int fy, boolean beepers) {
        int dy = Math.abs(fy - y);
        int dx = Math.abs(fx - x);
        
        int ix = x < fx ? 1 : -1; // increment direction
        int iy = y < fy ? 1 : -1;
        
        int x1 = x;
        int y1 = y;
        
        int xdir = ix < 0 ? 3 : 1;
        int ydir = iy < 0 ? 2 : 0;
        
        if (beepers) {
            int d = 0;
 
            int dfy = (dy << 1); // slope scaling factors to avoid floating
            int dfx = (dx << 1); // point
  
            if (dy <= dx) {
                for (;;) {
                    putBeeper();
                    if (x1 == fx)
                        break;
                    x1 += ix;
                    turnTo(xdir);
                    move();
                    d += dfy;
                    if (d > dx) {
                        turnTo(ydir);
                        move();
                        turnTo(xdir);
                        y1 += iy;
                        d -= dfx;
                    }
                }
            } else {
                for (;;) {
                    putBeeper();
                    if (y1 == fy)
                        break;
                    y1 += iy;
                    turnTo(ydir);
                    move();
                    d += dfx;
                    if (d > dy) {
                        turnTo(xdir);
                        move();
                        turnTo(ydir);
                        x1 += ix;
                        d -= dfy;
                    }
                }
            }
        } else {
            turnTo(xdir);
            move(dx);
            turnTo(ydir);
            move(dy);
        }
    }
}
