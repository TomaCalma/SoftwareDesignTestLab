package position;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Vector {

    public float x;
    public float y;
    double tresh;

    public Vector(float x, float y){
        this.x = x;
        this.y = y;
        this.tresh = 0.000001;
    }

    public Vector add(Vector other){
     return new Vector(this.x + other.x,this.y+other.y);
    }

    public Vector sub(Vector other){
        return new Vector(this.x - other.x,this.y-other.y);
    }

    Vector neg(){
        return new Vector(-this.x ,-this.y);
    }

    public Vector mul(float scalar){
        return new Vector(this.x * scalar,this.y*scalar);
    }

    Vector div(float scalar){
        if (scalar != 0){
        return new Vector(this.x / scalar,this.y/scalar);
        }
        return null;
    }

    Vector truediv(float scalar){
        return this.div(scalar);
    }

    boolean eq(Vector other){
        if (abs(this.x- other.x)<tresh){
            if (abs(this.y- other.y)<tresh){
                return true;
            }
        }
        return false;
    }

    public float magnitudeSquared(){
        return (this.x*this.x)+(this.y*this.y);
    }

    float magnitude(){
        return (float) sqrt(this.magnitudeSquared());
    }

    public Vector copy(){
        return new Vector(this.x,this.y);
    }
}
