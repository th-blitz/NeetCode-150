// Questions to ask in Interview
// 1. Can there be cycles in the graph?
// 2. Can there be multiple edges between two nodes?

/**
 * Backtracking + greedy
 * Use backtracking to trail all possible solutions.
 * Use Greedy to priotize the lowest lexical order solution. (This ensure that when we final the optimzal solutions, all the solutions that are of lower lexical order failed the trail.)
 *
 * T: O(F ^ d) -> F total flights, d is the atmost number of flights from a airport.
 * We can have F ^ d number of sequences.
 * S: O(A + F) -> A is number of airports, F is number of flights.
 */
// class Solution {
//     List<String> result = null;
//     int totalTicket;

//     public List<String> findItinerary(List<List<String>> tickets) {

//         HashMap<String, List<String>> adjList = new HashMap<String, List<String>>();

//         for (List<String> ticket : tickets) {
//             String from = ticket.get(0);
//             String to = ticket.get(1);

//             adjList.computeIfAbsent(from, k -> new ArrayList<String>()).add(to);
//         }

//         HashMap<String, boolean[]> visited = new HashMap<String, boolean[]>();

//         for (Map.Entry<String, List<String>> edges : adjList.entrySet()) {

//             Collections.sort(edges.getValue());

//             visited.put(edges.getKey(), new boolean[edges.getValue().size()]);
//         }

//         totalTicket = tickets.size();

//         List<String> route = new ArrayList<String>();
//         route.add("JFK");

//         backtrack(route, "JFK", adjList, visited);

//         return result;
//     }

//     private boolean backtrack(List<String> route, String origin, HashMap<String, List<String>> adjList, HashMap<String, boolean[]> visited) {

//         if (route.size() == totalTicket + 1) {
//             result = new ArrayList<>(route);
//             return true;
//         }

//         if (!adjList.containsKey(origin))
//             return false;


//         int i = 0;
//         boolean[] curVisited = visited.get(origin);

//         for (String dest : adjList.get(origin)) {

//             if (!curVisited[i]) {
//                 curVisited[i] = true;

//                 route.add(dest);

//                 boolean returnValue = backtrack(route, dest, adjList, visited);

//                 route.remove(route.size() - 1);
//                 curVisited[i] = false;

//                 if (returnValue) {
//                     return true;
//                 }
//             }
//             i++;
//         }
//         return false;
//      }
// }

/**
 * Hierholzer's Algorithm/Eulerian Cycle.
 *
 * 1. Step 1). Starting from any vertex, we keep following the unused edges until we get stuck at certain vertex where we have no more unvisited outgoing edges.
 * Step 2). We then backtrack to the nearest neighbor vertex in the current path that has unused edges and we repeat the process until all the edges have been used.
 *
 * This could also be considered as post order DFS traversal of a tree.
 * T: DFS traverse each edge once. Hence O(E) + sorting time complexity (N log N); N = E / 2. For not balanched graph. Hence, T: O(E * log (E / V))).
 * S: O(E + V).
 */
class Solution {
    LinkedList<String> result = new LinkedList<String>();
    int totalTicket;

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String, LinkedList<String>> adjList = new HashMap<String, LinkedList<String>>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adjList.computeIfAbsent(from, k -> new LinkedList<String>()).add(to);
        }

        adjList.forEach((key, value) -> Collections.sort(value));

        DFS("JFK", adjList);

        return result;
    }

    private void DFS(String origin, HashMap<String, LinkedList<String>> adjList) {

        if (adjList.containsKey(origin)) {
            LinkedList<String> destList = adjList.get(origin);

            while(!destList.isEmpty()) {

                DFS(destList.pollFirst(), adjList);
            }
        }

        result.offerFirst(origin);
    }
}