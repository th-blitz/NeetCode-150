/**
 * Using ArrayList with out any stack.
 * T: O(1)
 * S: O(N)
 */
// class MinStack {

//     List<int[]> arrayList;

//     public MinStack() {
//         arrayList = new ArrayList<int[]>();
//     }

//     public void push(int val) {

//         if (arrayList.isEmpty()) {
//             arrayList.add(new int[] {val, val});
//         } else {
//             int[] lastItem = arrayList.get(arrayList.size() - 1);
//             arrayList.add(new int[] {val, Math.min(lastItem[1], val)});
//         }
//     }

//     public void pop() {
//         arrayList.remove(arrayList.size() - 1);
//     }

//     public int top() {
//         return arrayList.get(arrayList.size() - 1)[0];
//     }

//     public int getMin() {
//         return arrayList.get(arrayList.size() - 1)[1];
//     }
// }

/**
 * Using two stacks.
 * T: O(1)
 * S: O(N)
 */
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        int pop = stack.pop();

        if (minStack.peek() == pop) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */