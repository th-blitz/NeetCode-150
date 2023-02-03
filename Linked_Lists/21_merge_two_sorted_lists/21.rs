mod list;


fn merge_two_sorted_lists(list1: Option<Box<list::SingleListNode>>, list2: Option<Box<list::SingleListNode>>) -> Option<Box<list::SingleListNode>> {

    match (list1, list2) {
        (None, Some(list2)) => return Some(list2),
        (Some(list1), None) => return Some(list1),
        (None, None) => None,
        (Some(list1), Some(list2)) => {
            if list1.val < list2.val {
                return Some(Box::new(list::SingleListNode{ val: list1.val, next: merge_two_sorted_lists(list1.next, Some(list2))}));
            } else {
                return Some(Box::new(list::SingleListNode{ val: list2.val, next: merge_two_sorted_lists(Some(list1), list2.next)})); 
            }
        },
    }
}


fn main() {

    
    let list1 = list::build_list(vec!(1, 2, 5, 8));
    let list2 = list::build_list(vec!(1, 3, 4, 6));

    print!("list 1 : ");
    list::print_nodes(&list1);

    print!("list 2 : ");
    list::print_nodes(&list2);

    let merged_list = merge_two_sorted_lists(list1, list2);
    
    print!("merged list : ");
    list::print_nodes(&merged_list);

}