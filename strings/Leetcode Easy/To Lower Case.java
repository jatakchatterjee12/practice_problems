//
class Solution {
    public String toLowerCase(String s) {
        
        char[] strAr = s.toCharArray();

        for(int i=0; i < s.length(); i++) {

            if(strAr[i] >= 'A' && strAr[i] <= 'Z') {
                strAr[i] = (char)(strAr[i] - 'A' + 'a');
            }
        }
        return new String(strAr);
    }
}

//Using Stream API
class Solution {
    	public String toLowerCase(String s) {
        char[] a = s.toCharArray();
        IntStream.range(0, a.length).filter(i -> a[i]  >= 'A' && a[i] <= 'Z').forEach(i -> a[i] = (char) (a[i] - 'A' + 'a'));
        return new String(a);
    }
}
