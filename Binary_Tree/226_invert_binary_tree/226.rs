
#[path = "../tree.rs"]
mod tree;


fn invert_tree(root: Option<Box<tree::BinaryTree>>) -> Option<Box<tree::BinaryTree>> {

    match root {
        None => return None,
        Some(root) => {
            return tree::BinaryTree::new(root.val, invert_tree(root.right), invert_tree(root.left));
        }
    }
}


fn main() {
    let mut root = tree::build_tree(&mut vec!(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    tree::print_tree(&root, 1);
    root = invert_tree(root);
    tree::print_tree(&root, 1);
}