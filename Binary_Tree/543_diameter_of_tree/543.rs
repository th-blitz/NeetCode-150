mod tree;
use std::cmp::max;


fn max_depth(root: &Option<Box<tree::BinaryTree>>) -> usize {

    fn recur(root: &Option<Box<tree::BinaryTree>>, maxDiameter: &mut usize) -> usize {
        match root {
            None => return 0 as usize,
            Some(root) => {

                let leftHeight = recur(&root.left, maxDiameter);
                let rightHeight = recur(&root.right, maxDiameter);
                let max_diameter = max(*maxDiameter, leftHeight + rightHeight);
                *maxDiameter = max_diameter;
                return max(leftHeight, rightHeight) + 1;
            }
        }
    }
    let mut maxDiameter = 0;
    let _height = recur(root, &mut maxDiameter);
    return maxDiameter;
}


fn main() {
    let root = tree::build_tree(&mut vec!(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    tree::print_tree(&root, 1);
    
    let diameter: usize = max_depth(&root);
    println!("diameter : {}", diameter);
}