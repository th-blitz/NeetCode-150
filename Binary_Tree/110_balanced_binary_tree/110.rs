
#[path = "../tree.rs"]
mod tree;

use std::cmp::max;

fn is_balanced(root : &Option<Box<tree::BinaryTree>>) -> bool {

    fn height(root: &Option<Box<tree::BinaryTree>>) -> i32 {
        match root {
            None => return -1,
            Some(node) => {
                return max(
                    height(&node.left),
                    height(&node.right)
                ) + 1;
            }
        }
    }

    fn balanced(root: &Option<Box<tree::BinaryTree>>) -> bool {
        match root {
            None => return true,
            Some(node) => return i32::abs(height(&node.left) - height(&node.right)) < 2 && balanced(&node.left) && balanced(&node.right),
        }
    }

    return balanced(root);
}




fn main() {
    let root = tree::build_tree(&mut vec!(1, 2, 3, 4, 5, 6, 7));
    tree::print_tree(&root, 1);

    let result = is_balanced(&root);
    println!("tree is balanced : {}", result);

}

