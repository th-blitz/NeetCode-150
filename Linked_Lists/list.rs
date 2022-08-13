


#[derive(Debug)]
pub struct SingleListNode {
    pub val: i32,
    pub next: Option<Box<SingleListNode>>,
}

impl SingleListNode {
    fn new(val: i32) -> SingleListNode {
        return SingleListNode{ val: val, next: None};
    }
}

pub fn build_list(array: Vec<i32>) -> Option<Box<SingleListNode>> {
    let mut current = None;
    
    for i in (0..array.len()).rev() {
        let mut new_node = SingleListNode::new(array[i]);
        new_node.next = current;
        current = Some(Box::new(new_node));
    }
    return current;
}

pub fn print_nodes(node: &Option<Box<SingleListNode>>) {
    match node {
        &Some(ref node) => {
            print!("{} > ", node.val);
            print_nodes(&node.next);
        },
        None => {
            println!("None");
        },
    }
}

// fn main() {

//     let array: Vec<i32> = vec!(1, 2, 3, 4, 5, 6, 7, 8);
//     let head = build_list(array);

//     print_nodes(&head);

// }