mod tree;
use std::cmp::max;

fn max_depth(root: &Option<Box<tree::BinaryTree>>) -> usize {

    match root {
        None => return 0 as usize,
        Some(root) => {
            return max(
                max_depth(&root.left),
                max_depth(&root.right)
            ) + 1;
        }
    }
}


fn main() {
    let root = tree::build_tree(&mut vec!(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    tree::print_tree(&root, 1);
    
    let max_depth: usize = max_depth(&root);
    println!("max depth : {}", max_depth);
}