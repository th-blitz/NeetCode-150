mod list;


// List Definition
// #[derive(Debug)]
// struct SingleListNode {
//     val: i32,
//     next: Option<Box<SingleListNode>>,
// }

// impl SingleListNode {
//     fn new(val: i32) -> SingleListNode {
//         return SingleListNode{ val: val, next: None};
//     }
// }



fn reverse_list(head: Option<Box<list::SingleListNode>>) -> Option<Box<list::SingleListNode>> {
    
    let mut prev_node = None;
    let mut next_node = head;

    while let Some(mut node) = next_node {
        next_node = node.next;
        node.next = prev_node;
        prev_node = Some(node);
    }
    return prev_node;
}



fn main() {

    let array: Vec<i32> = vec!(1, 2, 3, 4, 5, 6, 7, 8);
    let head = list::build_list(array);

    list::print_nodes(&head);

    let head = reverse_list(head);

    list::print_nodes(&head);
}