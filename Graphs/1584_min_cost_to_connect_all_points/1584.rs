struct DisjointSet {
    roots: Vec<usize>,
    rank: Vec<usize>
}

impl DisjointSet {
    
    fn new(n: usize) -> Self {
        return DisjointSet { roots: (0..n).collect(), rank: vec![0;n]};
    }

    fn find(&mut self, x: usize) -> usize {
        if x == self.roots[x] {
            return x;
        }
        self.roots[x] = self.find(self.roots[x]);
        return self.roots[x];
    }

    fn union(&mut self, x: usize, y: usize) {
        let rootX: usize = self.find(x);
        let rootY: usize = self.find(y);
        if rootX != rootY {
            if self.rank[rootX] > self.rank[rootY] {
                self.roots[rootY] = rootX;
            } else if self.rank[rootX] < self.rank[rootX] {
                self.roots[rootX] = rootY;
            } else {
                self.roots[rootY] = rootX;
                self.rank[rootX] += 1;
            }
        }
    }    
}

impl Solution {
    pub fn min_cost_connect_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut union_set: DisjointSet = DisjointSet::new(points.len());
        
        fn distance(a: &Vec<i32>, b: &Vec<i32>) -> i32 {
            return i32::abs(a[0] - b[0]) + i32::abs(a[1] - b[1]); 
        }

        let mut edges: Vec<(i32, usize, usize)> = Vec::new();

        for i in 0..points.len() {
            for j in i..points.len() {
                edges.push((distance(&points[i], &points[j]), i, j));
            }
        }

        edges.sort_by_key(|x| x.0);

        let mut result: i32 = 0;
        let mut i: usize = 0;
        let mut count: usize = 0;

        while count < points.len() - 1 {
            if union_set.find(edges[i].1) != union_set.find(edges[i].2) {
                union_set.union(edges[i].1, edges[i].2);
                count += 1;
                result += edges[i].0;
            }
            i += 1;
        }

        return result;
    }
}