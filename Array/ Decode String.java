class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']'){
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                while (repeat-- > 0)
                    prev.append(current);
                current = prev;
            } else{
                current.append(ch);
            }
        }
        return current.toString();
    }
}