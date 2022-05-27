import java.lang.Math;
public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName = "jupiter.gif";

    public Body(double xP, double yP, double xV,
              double yV, double m, String img){
      this.xxPos = xP;
      this.yyPos = yP;
      this.xxVel = xV;
      this.yyVel = yV;
      this.mass = m;
      this.imgFileName = img;
    }

    public double calcDistance(Body d){
      double yDis = (this.yyPos - d.yyPos)*(this.yyPos - d.yyPos);
      double xDis = (this.xxPos - d.xxPos)*(this.xxPos - d.xxPos);
      return Math.sqrt(yDis + xDis);
    }

    public double calcForceExertedBy(Body d){
      double dist = this.calcDistance(d);
      return 6.67*Math.pow(10,-11)*this.mass*d.mass/dist/dist;
    }

    public double calcForceExertedByX(Body d){
      double force = this.calcForceExertedBy(d);
      double dist = this.calcDistance(d);
      return (d.xxPos - this.xxPos)*force/dist;
    }

    public double calcForceExertedByY(Body d){
      double force = this.calcForceExertedBy(d);
      double dist = this.calcDistance(d);
      return (d.yyPos - this.yyPos)*force/dist; 
    }

    public double calcNetForceExertedByX(Body [] d){
      double netForce = 0.0;
      for (int i = 0; i< d.length; i++){
        if (this.equals(d[i])) {
          continue;
        }
        netForce = netForce + this.calcForceExertedByX(d[i]);
      }
      return netForce;
    }

    public double calcNetForceExertedByY(Body [] d){
      double netForce = 0.0;
      for (int i = 0; i< d.length; i++){
        if (this.equals(d[i])) {
          continue;
        }
        netForce = netForce + this.calcForceExertedByY(d[i]);
      }
      return netForce;
    }

    public Body (Body d){
      this.xxPos = d.xxPos;
      this.yyPos = d.yyPos;
      this.xxVel = d.xxVel;
      this.yyVel = d.yyVel;
      this.mass = d.mass;
      this.imgFileName = d.imgFileName;
    }

    public void update(double dt, double fX, double fY){
      double xAcel = fX/this.mass;
      double yAcel = fY/this.mass;
      this.xxVel = this.xxVel + dt*xAcel;
      this.yyVel = this.yyVel + dt*yAcel;
      this.xxPos = this.xxPos + this.xxVel * dt;
      this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw(){
      String address = "./images/"+this.imgFileName;
      StdDraw.picture(this.xxPos,this.yyPos,address);
    }
}