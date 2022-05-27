public class printRadius{
	public static void main (String [] args){
		In in = new In ("./data/planets.txt");
		int a = in.readInt();
		double radius = in.readDouble();
		System.out.println(radius);
	}
}