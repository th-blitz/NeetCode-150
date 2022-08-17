

#[derive(Debug)]
pub struct BinaryTree {
    pub val : i32,
    pub left : Option<Box<BinaryTree>>,
    pub right : Option<Box<BinaryTree>>
}


impl BinaryTree {

    pub fn new(val: i32, left: Option<Box<BinaryTree>>, right: Option<Box<BinaryTree>>) -> Option<Box<BinaryTree>> {
        return Some(Box::new(BinaryTree{val: val, left: left, right: right}));
    }

}


pub fn build_tree(array: &mut Vec<i32>) -> Option<Box<BinaryTree>> {
    let mut root = None;
    if array.len() > 0 {
        array.sort();
        fn recur(left: isize, right: isize, array: &Vec<i32>) -> Option<Box<BinaryTree>> {
            if left > right {
                return None;
            }
            let mid: isize = (left + right) / 2;
            return BinaryTree::new(array[mid as usize], recur(left, mid - 1, array), recur(mid + 1, right, array));
        }
        root = recur(0, (array.len() - 1) as isize, &array);
    }
    return root;
}

pub fn print_tree(node: &Option<Box<BinaryTree>>, indent: usize) {
    match (node, indent) {
        (&Some(ref node), indent) => {

            print_tree(&node.right, indent + 4);
        
            if indent > 1 {
                for _ in 0..indent {
                    print!(" ");
                }   
            }
            if let Some(_r) = &node.right {
                println!(" /");
                for _ in 0..indent {
                    print!(" ")
                }
            }
            println!("{}", node.val);

            if let Some(_l) = &node.left {
                for _ in 0..indent {
                    print!(" ");
                }
                println!(" \\");
            }

            print_tree(&node.left, indent + 4);

        },
        (None, _ ) => return,
    }
}


// fn main() {

//     let root = build_tree(&mut vec!(3, 2, 1, 4, 5, 3, 4, 5, 6, 3,7));
//     print_tree(&root, 0);
// }


