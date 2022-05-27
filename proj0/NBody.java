public class NBody{
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);
		StdDraw.setScale(-radius,radius);
		StdDraw.picture(0.0,0.0,"images/starfield.jpg");
		for (int i=0; i<bodies.length; i++) {
			bodies[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		double time = 0.0;
		while (time<=T){
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];
			for (int a=0; a<bodies.length; a++) {
				xForces[a] = bodies[a].calcNetForceExertedByX(bodies);
				yForces[a] = bodies[a].calcNetForceExertedByY(bodies);
			}
			for (int j=0; j<bodies.length; j++) {
				bodies[j].update(dt,xForces[j],yForces[j]);
			}
			StdDraw.picture(0.0,0.0,"images/starfield.jpg");
			for (int m=0; m<bodies.length; m++) {
				bodies[m].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;
		}
		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
            bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}

	public static double readRadius(String fileName){
		In in = new In(fileName);
		int total_num = in.readInt();
		double scale = in.readDouble();
		return scale;
	}

	public static Body[] readBodies(String file){
		In in = new In(file);
		int total_num = in.readInt();
		Body [] stars = new Body [total_num];
		double scale = in.readDouble();
		double xxPos;
		double yyPos;
		double xxVel;
		double yyVel;
		double mass;
		String imgFileName;
		for (int i = 0; i<total_num; i++) {
			xxPos = in.readDouble();
			yyPos = in.readDouble();
			xxVel = in.readDouble();
			yyVel = in.readDouble();
			mass = in.readDouble();
			imgFileName = in.readString();
			stars[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}		
		return stars;
	}

}