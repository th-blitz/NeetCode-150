use std::collections::HashMap;

fn is_valid(s: &String) -> bool {

    let brackets: HashMap<char, char> = HashMap::from([
        (')', '('),
        ('}', '{'),
        (']', '[')
    ]);
    let string_array: Vec<char> = s.chars().collect();
    let mut stack: Vec<char> = Vec::new();

    for x in string_array {
        if brackets.contains_key(&x) == false {
            stack.push(x);
        } else if (stack.is_empty() == false) && (*brackets.get(&x).unwrap() == stack.pop().unwrap()) {
            continue;
        } else {
            return false;
        }
    }
    
    return stack.is_empty();
}


fn main() {

    let mut s: String = String::from("{{([])[]}}");
    println!("test case : {} result : {} ", s, is_valid(&s));

    s = String::from("{{([][]}}");
    println!("test case : {} result : {} ", s, is_valid(&s));
}