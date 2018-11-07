package string_test;

/**
 * ������ִ�����
 * 
 * �ο���
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
            //�����������ַ���
            helper(s, i, 0);
            //����ż�����ַ���
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
        // �س���ǰ����Ӵ�
        String currLongest = s.substring(left + 1, right);
        // �ж��Ƿ��ȫ�������
        if(currLongest.length() > longest.length()){
            longest = currLongest;
        }
    }

}
