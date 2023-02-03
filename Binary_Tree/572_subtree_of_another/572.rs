#[path = "../tree.rs"]
mod tree;


fn is_same(p: &Option<Box<tree::BinaryTree>>, q: &Option<Box<tree::BinaryTree>>) -> bool {

    match (p, q) {
        (None, None) => return true,
        (_, None) | (None, _) => return false,
        (Some(p), Some(q)) => {
            if p.val != q.val {
                return false;
            }
            return is_same(&p.left, &q.left) && is_same(&p.right, &q.right);
        } 
    }
}

fn is_sub_tree(root: &Option<Box<tree::BinaryTree>>, subRoot: &Option<Box<tree::BinaryTree>>) -> bool {

    let compare_tree = is_same(root, subRoot);

    match root {
        None => return false,
        Some(root) => {
            return is_sub_tree(&root.left, &subRoot) || is_sub_tree(&root.right, &subRoot) || compare_tree;
        }
    }
}




fn main() {
    let p = tree::build_tree(&mut vec!(2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
    tree::print_tree(&p, 1);

    let q = tree::build_tree(&mut vec!(7, 9, 8, 10, 11));
    tree::print_tree(&q, 1);

    let result = is_sub_tree(&p, &q);
    println!("tree is same : {}", result);

}

