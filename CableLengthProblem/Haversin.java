import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class graph1 {
	List<Node1> node = new ArrayList<Node1>();
	List<Edges1> edges = new ArrayList<Edges1>();
}

class Node1 {
	int name;
}

class Edges1 {
	int start;
	int end;
	double distance;
	
	public static Comparator<Edges1> distanceComparator = new Comparator<Edges1>() {

		

		public int compare(Edges1 s1, Edges1 s2) {
			// TODO Auto-generated method stub
			double rollno1 = s1.distance;
			   double rollno2 = s2.distance;
			   /*For ascending order*/
			   return (int) (rollno1-rollno2);
		}		
};
}


public class Haversin {
	public static double haversine(double lat1, double lon1, double lat2,
			double lon2, double R) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2)
				* Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s;
		int datasetsize = Integer.parseInt(in.nextLine());
		String arraystatus[] = new String[datasetsize];
		for (int i = 0; i < datasetsize; i++) {
			double diameter = Double.parseDouble(in.nextLine());
			double radius = diameter / 2;
			double cablelength = Double.parseDouble(in.nextLine());
			int numcities = Integer.parseInt(in.nextLine());
			Map<Integer, List<Double>> citydetails = new HashMap<Integer, List<Double>>();

			for (int j = 0; j < numcities; j++) {
				s = in.nextLine();
				String axisdetails[] = s.split(" ");
				List<Double> xyaxis = new ArrayList<Double>();
				xyaxis.add(Double.parseDouble(axisdetails[0]));
				xyaxis.add(Double.parseDouble(axisdetails[1]));
				citydetails.put(j, xyaxis);
			}
			Double[][] adjacencymatrix = new Double[numcities][numcities];

			for (int x = 0; x < numcities; x++) {
				for (int y = 0; y < numcities; y++) {
					adjacencymatrix[x][y] = 0.0;
				}
			}
			for (int node1 = 0; node1 < numcities; node1++) {
				for (int node2 = node1 + 1; node2 < numcities; node2++) {
					List city1 = citydetails.get(node1);
					List city2 = citydetails.get(node2);
					double distance = haversine((Double) city1.get(0),
							(Double) city1.get(1), (Double) city2.get(0),
							(Double) city2.get(1), radius);
					adjacencymatrix[node1][node2] = distance;
				}
			}
			
		
	
			graph1 g1 = new graph1();
			
			for (int k=0;k<numcities;k++) {	
				Node1 n = new Node1();
				n.name = k;
				g1.node.add(n);
			}
				
				for (int x=0;x<numcities;x++) {
					for(int y=0;y<numcities;y++)
					{
					Edges1 e = new Edges1();
					e.distance = adjacencymatrix[x][y];
					e.start = x;
					e.end = y;
					g1.edges.add(e);
					}
				}

			
			Collections.sort(g1.edges, Edges1.distanceComparator);
			graph1 g2 = new graph1();
			for(Edges1 g : g1.edges)
			{
				if(g.distance >0 && g2.node.contains(g.end)!=true && g2.node.contains(g.start)!=true && g2.node.size()<numcities)
				{
					Node1 n1 = new Node1();
					n1.name =g.start;
					Node1 n2 = new Node1();
					n2.name = g.end;
					g2.node.add(n1);
					g2.node.add(n2);
					g2.edges.add(g);
				}
			}
			double totaldistance = 0;
			for(Edges1 g : g2.edges)
			{
				totaldistance = totaldistance + g.distance;
			}
			
			if(cablelength>=totaldistance)
			{
				arraystatus[i] = "IS POSSIBLE";
			}
			else
			{
				arraystatus[i]= "IS NOT POSSIBLE";
			}
		}
		
		for(int i=0;i<datasetsize;i++)
		{
			System.out.println(arraystatus[i]);
		}
	}
}