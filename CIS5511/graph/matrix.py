from queue import PriorityQueue
import copy
class Graph:
    def __init__(self, vertices, directed=True):
        # initialize variables
        # set input vertices
        self.v = vertices
        #set matrix as all 0
        self.matrix = [[0 for m in range(vertices)] for n in range(vertices)]
        # set type as an object
        self.type = directed
        
    def add_edge(self, node1, node2, weight=1): # default weight is 1
        # add edge in one direction 
        self.matrix[node1][node2] = weight
        # add edge in the other direct if its not directed
        if not self.type:
            self.matrix[node2][node1] = weight
    
    def print_adj_matrix(self):
        # printing the matrix out 
        for i in range(self.v):
            print(self.matrix[i])
    
    def bfs(self, start):
        # Initialize visited set
        visited = [False] * self.v
        queue = [start]
        # Mark the starting node as true for visited
        visited[start] = True
        # search through queue until all results are popped
        while queue:
            # add currNode to queue
            curr = queue[0]
            # Print starting node and pop the node
            print(curr, end = ' ')
            queue.pop(0)
             
            # Find all ajacent nodes 
            for i in range(self.v):
                # Look for node not visited and in matrix
                if (self.matrix[curr][i] == 1 and (not visited[i])):
                    # add it to the queue
                    queue.append(i)
                    # set the visited queue index to be true after visited
                    visited[i] = True
    
    def dfs(self, start, visited):
        # Print starting node
        print(start, end = ' ')
 
        # Mark the starting node as true
        visited[start] = True
 
        # For all the node in the graph, assuming all numbers
        for i in range(self.v):

            # Look for node not visited and in matrix
            if (self.matrix[start][i] == 1 and
                    (not visited[i])):
                # recusively node not visited and in matrix
                self.dfs(i, visited)
    
    def dijkstra(self, start):
        # set infinity for all vertex
        D = {v:float('inf') for v in range(self.v)}
        # add cost to start node 
        D[start] = 0
        #initialize priority queue
        pq = PriorityQueue()
        # add it to prority queue
        pq.put((0, start))
        
        visited = []
        
        # loop until pq is empty
        while not pq.empty():
            # get current vertex from pq
            (dist, currNode) = pq.get()
            # add it to visited list
            visited.append(currNode)
            # search through all neighbors in graph assuming all are numbers
            for neighbor in range(self.v):
                # check there is path
                if self.matrix[currNode][neighbor] != 0:
                    # find the weight for the node
                    distance = self.matrix[currNode][neighbor]
                    # check not in visited
                    if neighbor not in visited:
                        # calculate the next and current node cost
                        old_cost = D[neighbor]
                        new_cost = D[currNode] + distance
                        # if node cost less, add it to dijstra 
                        # and priority queue for it to start as next node
                        if new_cost < old_cost:
                            pq.put((new_cost, neighbor))
                            # print(pq.queue)
                            D[neighbor] = new_cost
        return D

def part1():
    # initialized graph and vertices
    v = 5
    #functions works for both directed and indirected
    graph = Graph(v, directed=False)
    # added edges to graph
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 3)
    graph.add_edge(2, 3)
    graph.add_edge(3, 4)
    # print adjacent matrix
    graph.print_adj_matrix()

    #DFS  
    print("DFS")
    # due to recusion, the visited list needs to be outside
    visited = [False] * v
    graph.dfs(0,visited)
    print()
    #BFS  
    print("BFS")
    graph.bfs(0)
    print()

def part2():
    #initialized graph and vertices 
    v = 11
    g = Graph(v,directed=True)
    g.add_edge(0,1,7)
    g.add_edge(0,2,8)
    g.add_edge(0,3,6)
    g.add_edge(1,4,9)
    g.add_edge(1,7,8)
    g.add_edge(2,5,7)
    g.add_edge(2,6,6)
    g.add_edge(3,4,4)
    g.add_edge(3,6,3)
    g.add_edge(3,7,3)
    g.add_edge(4,8,7)
    g.add_edge(4,9,6)
    g.add_edge(5,8,5)
    g.add_edge(6,8,4)
    g.add_edge(6,9,7)
    g.add_edge(7,8,5)
    g.add_edge(8,10,4)
    g.add_edge(9,10,3)
    g.print_adj_matrix() # print the adjacency matrix
    
    costList = {}
    #for loop that cost through all vertices
    for i in range(v):
        #create deepcopy g so dijstra don't overlap
        newG = copy.deepcopy(g)
        A = newG.dijkstra(i)
        # get dijkstra from all different starting vertices
        costList[i] = A[10]
    print("Cost Table From Quiz 8, Backward")
    print(costList)
    
    # print dijkstra path start node as 0
    print("Dijkstra from 0 path from algorithm, Forward")
    D = g.dijkstra(0)
    print(D)
    #for loop to show the path of dijkstra
    for vertex in range(len(D)):
        print("Distance from v: 0 to v:",vertex, ", cost =", D[vertex])

if __name__=="__main__":
    part1()
    print()
    part2()