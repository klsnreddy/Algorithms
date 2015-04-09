import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;


public class BaseballElimination {
    
    private String[] teams;
    private int[] wins;
    private int[] losses;
    private int[] remaining;
    private int[][] schedule;
    
    private boolean[] eliminated;
    private LinkedHashSet<String>[] reason;
    
    private Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    
    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In in = new In(filename);
        int noOfTeams = in.readInt();
        
        teams = new String[noOfTeams];
        wins = new int[noOfTeams];
        losses = new int[noOfTeams];
        remaining = new int[noOfTeams];
        schedule = new int[noOfTeams][noOfTeams];
        eliminated = new boolean[noOfTeams];
        reason = (LinkedHashSet<String>[]) new LinkedHashSet[noOfTeams];
        
        int max = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < noOfTeams; i++) {
            teams[i] = in.readString();
            map.put(teams[i], Integer.valueOf(i));
            wins[i] = in.readInt();
            losses[i] = in.readInt();
            remaining[i] = in.readInt();
            
            for (int j = 0; j < noOfTeams; j++) {
                schedule[i][j] = in.readInt();
            }
            
            if (max < wins[i]) {
                max = wins[i];
                maxIdx = i;
            }
        }
        
        for (int i = 0; i < noOfTeams; i++) {
            if (wins[i] + remaining[i] < max) {
                eliminated[i] = true;
                LinkedHashSet<String> itr = new LinkedHashSet<String>();
                reason[i] = itr;
                itr.add(teams[maxIdx]);
            }
        }
        
        int source = noOfTeams * noOfTeams;
        
        for (int i = 0; i < noOfTeams; i++) {
            if (eliminated[i])
                continue;
            
            LinkedHashSet<String> itr = reason[i];
            
            FlowNetwork fn = createFlowNetwrk(i);
            FordFulkerson ff = new FordFulkerson(fn, source, source + 1);
            for (FlowEdge fe : fn.adj(source)) {
                if (fe.residualCapacityTo(fe.to()) > 0) {
                    if (null == itr)
                        itr = new LinkedHashSet<String>();
                    for (int j = 0; j < source - 1; j++) {
                        if (ff.inCut(j)) {
                            itr.add(teams[j % noOfTeams]);
//                            itr.add(teams[j / noOfTeams]);
                        }
                    }
                    
                    eliminated[i] = true;
                }
            }
            
            reason[i] = itr;
        }
        
    }
    
    private FlowNetwork createFlowNetwrk(int idx) {
        int noOfTeams = teams.length;
        FlowNetwork fn = new FlowNetwork(noOfTeams * noOfTeams + 2);
        int source = noOfTeams * noOfTeams;
        int target = noOfTeams * noOfTeams + 1;
        for (int i = 0; i < noOfTeams; i++) {
            if (i == idx)
                continue;
            for (int j = 0; j < noOfTeams; j++) {
                if (j == idx || i >= j || schedule[i][j] <= 0)
                    continue;
                fn.addEdge(new FlowEdge(noOfTeams * i + j, noOfTeams * idx + j, Integer.MAX_VALUE));
                fn.addEdge(new FlowEdge(noOfTeams * i + j, noOfTeams * idx + i, Integer.MAX_VALUE));
                fn.addEdge(new FlowEdge(source, noOfTeams * i + j, schedule[i][j]));
            }
        }
        
        for (int i = 0; i < noOfTeams; i++) {
            for(FlowEdge fe : fn.adj(noOfTeams * idx + i)) {
                fn.addEdge(new FlowEdge(noOfTeams * idx + i, target, wins[idx] + remaining[idx] - wins[i]));
                break;
            }
        }
        return fn;
    }

    // number of teams
    public int numberOfTeams() {
        return teams.length;
    }
    
    // all teams
    public Iterable<String> teams()  {
        return map.keySet();
    }
    
    // number of wins for given team
    public int wins(String team) {
        checkTeam(team);
        return wins[map.get(team).intValue()];
    }
    
    // number of losses for given team
    public int losses(String team) {
        checkTeam(team);
        return losses[map.get(team).intValue()];
    }
    
    // number of remaining games for given team
    public int remaining(String team) {
        checkTeam(team);
        return remaining[map.get(team).intValue()];
    }
    
    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        checkTeam(team1);
        checkTeam(team2);
        return schedule[map.get(team1).intValue()][map.get(team2).intValue()];
    }
    
    // is given team eliminated?
    public boolean isEliminated(String team) {
        checkTeam(team);
        return eliminated[map.get(team).intValue()];
    }
    
    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        checkTeam(team);
        return reason[map.get(team).intValue()];
    }
    
    
    private void checkTeam(String team) {
        if (!map.containsKey(team))
            throw new IllegalArgumentException("Team " + team + " is not found.");
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination("teams5.txt");
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }

    }

}
