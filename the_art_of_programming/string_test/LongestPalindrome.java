package string_test;

/**
 * 最长回文字串处理
 * 
 * 参考：
 * 
 * https://segmentfault.com/a/1190000002991199#articleHeader10
 * 
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md
 * @author sshhsun
 *
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String result = new LongestPalindrome().longestPalindrome("acabbacasef");
		System.out.println("" + result);
	}
	String longest = "";
    public String longestPalindrome(String s) {
    	
        for(int i = 0; i < s.length(); i++){
            //计算奇数子字符串
            helper(s, i, 0);
            //计算偶数子字符串
            helper(s, i, 1);
        }
        return longest;
    }
    
    private void helper(String s, int idx, int offset){
        int left = idx;
        int right = idx + offset;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        // 截出当前最长的子串
        String currLongest = s.substring(left + 1, right);
        // 判断是否比全局最长还长
        if(currLongest.length() > longest.length()){
            longest = currLongest;
        }
    }

}
