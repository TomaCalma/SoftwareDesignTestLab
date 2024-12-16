package texts;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import position.Vector;

import java.awt.*;
import java.util.List;
import java.util.SimpleTimeZone;

public class Text {
    Vector position;
    String text;
    float x1;
    float y1;
    double time ;
    double timer ;
    boolean destroy;
    boolean visible;

    public String[][] a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,zero,one,two,three,four,five,six,seven,eight,nine,space;

    Text(String text , float x1 , float y1 , double time , boolean visible){
        this.text=text;
        this.x1 = x1;
        this.y1 = y1;
        this.time = time;
        this.visible = visible;
        this.position = new Vector(x1,y1);
        this.timer = 0;
        this.destroy = false;
        getSprites();
    }

    void getSprites(){
        space = new String[][]{
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
        };
        a = new String[][]{
                {"","","w","w","w","",""},
                {"","w","w","","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
        };
        b = new String[][]{
                {"w","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","w","w","w","w",""},
        };
        c = new String[][]{
                {"","","w","w","w","w",""},
                {"","w","w","","","w","w"},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"","w","w","","","w","w"},
                {"","","w","w","w","w",""},
        };
        d = new String[][]{
                {"w","w","w","w","w","",""},
                {"w","w","","","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","w","w",""},
                {"w","w","w","w","w","",""},
        };
        e = new String[][]{
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","w","w","w","w","w"},
        };
        f = new String[][]{
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","w","w","w","w",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
        };
        g = new String[][]{
                {"","","w","w","w","w","w"},
                {"","w","w","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","w","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","","","w","w"},
                {"","","w","w","w","w","w"},
        };
        h = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
        };
        i = new String[][]{
                {"","w","w","w","w","w","w"},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","w","w","w","w","w","w"},
        };
        j = new String[][]{
                {"","","","","","w","w"},
                {"","","","","","w","w"},
                {"","","","","","w","w"},
                {"","","","","","w","w"},
                {"","","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        k = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","","","w","w",""},
                {"w","w","","w","w","",""},
                {"w","w","w","w","","",""},
                {"w","w","w","w","w","",""},
                {"w","w","","","w","w",""},
                {"w","w","","","","w","w"},
        };
        l = new String[][]{
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
                {"w","w","w","w","w","w","w"},
        };
        m = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","w","","w","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","","w","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
        };
        n = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","w","","","w","w"},
                {"w","w","w","w","","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","","w","w","w","w"},
                {"w","w","","","w","w","w"},
                {"w","w","","","","w","w"},
        };
        o = new String[][]{
                {"","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        p = new String[][]{
                {"w","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","w","w","w","w",""},
                {"w","w","","","","",""},
                {"w","w","","","","",""},
        };
        q = new String[][]{
                {"","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","w","w","w","w"},
                {"w","w","","","w","w",""},
                {"","w","w","w","w","","w"},
        };
        r = new String[][]{
                {"w","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","","","","w","w","w"},
                {"w","w","w","w","w","",""},
                {"w","w","","w","w","w",""},
                {"w","w","","","w","w","w"},
        };
        s = new String[][]{
                {"","w","w","w","w","",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","",""},
                {"","w","w","w","w","w",""},
                {"","","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        t = new String[][]{
                {"","w","w","w","w","w","w"},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
        };
        u = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","","w","w","w","w",""},
        };
        v = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","w","","w","w","w"},
                {"","w","w","w","w","w",""},
                {"","","w","w","w","",""},
                {"","","","w","","",""},
        };
        w = new String[][]{
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","w","","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","w","w","w","w","w"},
                {"w","w","w","","w","w","w"},
                {"w","w","","","","w","w"},
        };
        x = new String[][]{
                {"x","x","","","","x","x"},
                {"x","x","x","","x","x","x"},
                {"","x","x","","x","x",""},
                {"","","x","x","x","",""},
                {"","","x","x","x","x",""},
                {"x","x","x","","x","x","x"},
                {"x","x","","","","x","x"},
        };
        y = new String[][]{
                {"","w","w","","","w","w"},
                {"","w","w","","","w","w"},
                {"","w","w","","","w","w"},
                {"","","w","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
        };
        z = new String[][]{
                {"w","w","w","w","w","w","w"},
                {"","","","","w","w","w"},
                {"","","","w","w","w",""},
                {"","","w","w","w","",""},
                {"","w","w","w","","",""},
                {"w","w","w","","","",""},
                {"w","w","w","w","w","w","w"},
        };
        zero = new String[][]{
                {"","","w","w","w","",""},
                {"","w","","","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","","","w",""},
                {"","","w","w","w","",""},
        };
        one = new String[][]{
                {"","","","w","w","",""},
                {"","","w","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","","","w","w","",""},
                {"","w","w","w","w","w","w"},
        };
        two = new String[][]{
                {"","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"","","","","","w","w"},
                {"","","","","w","w","w"},
                {"","","w","w","w","",""},
                {"w","w","w","","","",""},
                {"w","w","w","w","w","w","w"},
        };
        three = new String[][]{
                {"","w","w","w","w","w","w"},
                {"","","","","w","w",""},
                {"","","","w","w","",""},
                {"","","w","w","w","w",""},
                {"","","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        four = new String[][]{
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","",""},
                {"w","w","w","w","w","w",""},
                {"","","","","","w","w"},
                {"","","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        five = new String[][]{
                {"w","w","w","w","w","w",""},
                {"w","w","","","","",""},
                {"w","w","w","w","w","w",""},
                {"","","","","","w","w"},
                {"","","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        six = new String[][]{
                {"","","w","w","w","w",""},
                {"","w","w","","","",""},
                {"w","w","","","","",""},
                {"w","w","w","w","w","",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        seven= new String[][]{
                {"w","w","w","w","w","w","w"},
                {"w","w","","","","w","w"},
                {"","","","","w","w",""},
                {"","","","w","w","",""},
                {"","","w","w","","",""},
                {"","","w","w","","",""},
                {"","","w","w","","",""},
        };
        eight = new String[][]{
                {"","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w",""},
        };
        nine = new String[][]{
                {"","w","w","w","w","w",""},
                {"w","w","","","","w","w"},
                {"w","w","","","","w","w"},
                {"","w","w","w","w","w","w"},
                {"","","","","","w","w"},
                {"","","","","w","w",""},
                {"","w","w","w","w","",""},
        };
    }

    void draw(TextGraphics graphics){
        x1 = position.x;
        y1 = position.y;
        char[] ch = text.toCharArray();
        String[][] currimage = null;
        if (visible){
        for (Character chara:ch){
            switch (chara){
                case '1' :currimage = one; break;
                case '2' :currimage = two; break;
                case '3' :currimage = three; break;
                case '4' :currimage = four; break;
                case '5' :currimage = five; break;
                case '6' :currimage = six; break;
                case '7' :currimage = seven; break;
                case '8' :currimage = eight; break;
                case '9' :currimage = nine; break;
                case 'a' :currimage = a; break;
                case 'b' :currimage = b; break;
                case 'c' :currimage = c; break;
                case 'd' :currimage = d; break;
                case 'e' :currimage = e; break;
                case 'f' :currimage = f; break;
                case 'g' :currimage = g; break;
                case 'h' :currimage = h; break;
                case 'i' :currimage = i; break;
                case 'j' :currimage = j; break;
                case 'k' :currimage = k; break;
                case 'l' :currimage = l; break;
                case 'm' :currimage = m; break;
                case 'n' :currimage = n; break;
                case 'o' :currimage = o; break;
                case 'p' :currimage = p; break;
                case 'q' :currimage = q; break;
                case 'r' :currimage = r; break;
                case 's' :currimage = s; break;
                case 't' :currimage = t; break;
                case 'u' :currimage = u; break;
                case 'v' :currimage = v; break;
                case 'w' :currimage = w; break;
                case 'x' :currimage = x; break;
                case 'y' :currimage = y; break;
                case 'z' :currimage = z; break;
                case '_' :currimage = space; break;
            }
            if(currimage != null){
            ColorConverter.draw(graphics,currimage, (int) x1, (int) y1);
            x1 += 7 ;
            }
        }
        }
    }

    public void setText(String value) {
        text = value;
    }

    public void update() {
        if (time != -1){
            timer += 1;
        }
        if (timer>=time){
            timer = 0;
            destroy = true;
        }
    }
}
