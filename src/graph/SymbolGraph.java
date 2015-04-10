package graph;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.introcs.In;

public class SymbolGraph {

	private Map<String, Integer> map;
	private String[] keys;
	private Graph g;
	
	public SymbolGraph(String stream, String sp) {
		map = new HashMap<String, Integer>();
		In in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for(int i = 0; i < a.length; i++)
				if(!map.containsKey(a[i]))
					map.put(a[i], map.size());
		}
		
		keys = new String[map.size()];
		for(String key : map.keySet())
			keys[map.get(key)] = key;
		
		g = new Graph(map.size());
		in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = map.get(a[0]);
			for(int i = 1; i < a.length; i++)
				g.addEdge(v, map.get(a[i]));
		}
	}

	public boolean contains(String key) {
		return map.containsKey(key);
	}
	
	public int index(String key) {
		return map.get(key);
	}
	
	public String name(int v) {
		return keys[v];
	}
	
	public Graph graph() {
		return g;
	}
	
}
