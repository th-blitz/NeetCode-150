
fn is_palindrome(s: &String) -> bool {

    let string_vec: Vec<char> = s.to_lowercase().chars().collect();
    let mut i: usize = 0;
    let mut j: usize = string_vec.len() - 1;

    while i < j {
        while (i < j) && (string_vec[i].is_alphanumeric() == false) {
            i += 1;
        }
        while (i < j) && (string_vec[j].is_alphanumeric() == false) {
            if j == 0 {break;}
            j -= 1;
        }
        if string_vec[i] != string_vec[j] {
            return false;
        }
        i += 1;
        if j == 0 {break;}
        j -= 1;
    }
    return true;
}

fn main() {
    let s: String = String::from("A man, a plan, a canal: Panama");

    println!("result : {} ", is_palindrome(&s));

}

