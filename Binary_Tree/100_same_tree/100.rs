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




fn main() {
    let p = tree::build_tree(&mut vec!(1, 2, 3, 4, 5, 6, 7));
    tree::print_tree(&p, 1);

    let q = tree::build_tree(&mut vec!(1, 2, 3, 4, 5, 6, 7));
    tree::print_tree(&q, 1);

    let result = is_same(&p, &q);
    println!("tree is same : {}", result);

}

