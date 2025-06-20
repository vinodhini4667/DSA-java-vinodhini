class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set=new HashSet<>();

        for(char ch:s.toCharArray())
        {
            set.add(ch);
        }
        return set.size(); 
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.minimizedStringLength(s));
    }
}
