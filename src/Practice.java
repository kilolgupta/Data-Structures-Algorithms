import java.util.*;

public class Practice {

    private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummyHead = new ListNode(0);
       ListNode p=l1, q=l2, curr=dummyHead;
        int carry = 0;
        while(p!=null || q!=null) {
            int x = (p!=null)?p.val : 0;
            int y = (q!=null)?q.val : 0;
            int sum = (x+y+carry);
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0) curr.next = new ListNode(carry);

       return dummyHead.next;
    }

    private static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int cur_len=1, max_len = 1, n=s.length(), prev_index, no_of_chars = 256;
        int[] visited = new int[no_of_chars];
        for(int i=0;i<no_of_chars;i++) visited[i] = -1;

        // 1st character visited, lengths are initialised to 1
        visited[s.charAt(0)] = 0;

        for(int i=1;i<n;i++) {
            prev_index = visited[s.charAt(i)];

            if(prev_index==-1 || i-cur_len > prev_index) cur_len++;
            else {
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }
            visited[s.charAt(i)] = i;
        }
        if (cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }

    private static int lengthOfLongestNRCS(String s) {
        int n= s.length(), ans = 0;
        HashMap<Character, Integer> hashMapOfChars = new HashMap<>();
        int i=0, j=0;
        while(j<n) {
            if(hashMapOfChars.containsKey(s.charAt(j))) {
                i = (hashMapOfChars.get(s.charAt(j)) + 1 > i)? hashMapOfChars.get(s.charAt(j))+1 : i;
            }
            hashMapOfChars.put(s.charAt(j), j);
            j++;
            ans = (ans>j-i)? ans: j-i;
        }
        return ans;
    }

    private static double merge (int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2=nums2.length, n = (l1+l2)/2;
        int[] result = new int[l1+l2];
        int i=0, j=0, k=0;
        while(i<l1 && j<l2) {
            if(nums1[i]<nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
            if(k == n+1) break;
        }

        if(i==l1 && k!=n+1) {
            while(j<l2) {
                result[k++] = nums2[j++];
                if(k == n+1) break;
            }
        }

        else if(j==l2 && k!=n+1) {
            while(i<l1) {
                result[k++] = nums1[i++];
                if(k == n+1) break;
            }
        }

        if((l1+l2)%2==0) return (result[k-1] + result[k-2])/2.0;
        else {
            return result[k-1];
        }
    }

    private static String longestPalindromicSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return s;
        String lps = "";
        int max_i=0, max_j=0, lps_length = 1;
        // We will be filling the upper right corner as we are scanning substring left to right
        int[][] memoizedValues = new int[n][n];
        for(int i=0;i<n;i++) memoizedValues[i][i] = 1;  // substrings of length 1 are palindromes of length 1
        for(int i=0;i<n-1;i++) {
            if(s.charAt(i)==s.charAt(i+1)) memoizedValues[i][i+1] = 2; // substring of length 2
            if(memoizedValues[i][i+1]>lps_length) {
                lps_length = memoizedValues[i][i+1];
                max_i = i;
                max_j=i+1;
            }
        }
        int step = 2;
        while(step<n) {
            int i=0;
            int j = i+step;
            while(j<n) {
                if(memoizedValues[i+1][j-1]!=0 && s.charAt(i)==s.charAt(j)) memoizedValues[i][j] = j-i+1;
                if(memoizedValues[i][j]>lps_length) {
                    lps_length = memoizedValues[i][j];
                    max_i = i;
                    max_j=j;
                }
                i++;
                j=i+step;
            }
            step++;
        }
        return s.substring(max_i, max_j+1);
    }

    private static String lps(String s) {
        int maxLength = 1;  // The result (length of LPS)
        int start = 0;
        int len = s.length();
        int low, high;
        // One by one consider every character as center point of
        // even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with center points
            // as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high))
            {
                if (high - low + 1 > maxLength)
                {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with center
            // point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high))
            {
                if (high - low + 1 > maxLength)
                {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return s.substring(start, start+maxLength);
    }

    private static String zigZagConversion(String text, int nRows) {
        if(text.length()<=nRows) return text;
        if(nRows==1) return text;

        String result = new String();
            ArrayList<Character> convertedString[] = new ArrayList[nRows];
            for (int i = 0; i < nRows; i++) {
                convertedString[i] = new ArrayList<Character>();
            }
            int index = 0;
            int direction = 0; // 0 means down, 1 means up
            for (int i = 0; i < text.length(); i++) {
                if (direction == 0) {
                    convertedString[index++].add(text.charAt(i));
                    if (index == nRows) {
                        direction = 1;
                        index = nRows - 1;
                    }
                } else if (direction == 1) {
                    convertedString[--index].add(text.charAt(i));
                    if (index == 0) {
                        direction = 0;
                        index = 1;
                    }
                }
            }
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < convertedString[i].size(); j++) {
                    result = result + convertedString[i].get(j);
                    System.out.print(convertedString[i].get(j));
                }
            }
            return result;
    }

    private static int reverse(int x) {
        int reverseX=0, isNegative = 0, prev_rev = 0;
            if(x<0) {
                isNegative = 1;
                x = x*-1;
            }
            while(x>0) {
                reverseX= reverseX*10 + x%10;
                if((reverseX - x%10)/10 != prev_rev) return 0;
                x/=10;
                prev_rev = reverseX;
            }
        if(isNegative==1) {
                reverseX= reverseX*-1;
            }
        return reverseX;
    }

    private static int atoi(String str) {
        if(str.length()==0) return 0;
        int ans = 0, isNegative = 0, prev_ans=0, start_index=0;
        while(str.charAt(start_index)== ' ') start_index++;
        if(str.charAt(start_index)=='-') {
            isNegative = 1;
            start_index++;
        }
        else if(str.charAt(start_index)=='+')
            start_index++;
        for(int i=start_index;i<str.length();i++) {
            if(str.charAt(i) > 57 || str.charAt(i)<48) {
                if(isNegative==1) return ans*-1;
                else return ans;
            }
            ans = ans*10 + (str.charAt(i)-48);
            if(isNegative==0) {
                if((ans-(str.charAt(i)-48))/10 != prev_ans) return Integer.MAX_VALUE;
                if(ans<0 && prev_ans>0) return Integer.MAX_VALUE;
            }
            else {
                if((ans-(str.charAt(i)-48))/10 != prev_ans) return Integer.MIN_VALUE;
                if(ans<0 && prev_ans>0) return Integer.MIN_VALUE;
            }
            prev_ans = ans;
        }
        if(isNegative==1) return ans*-1;
        return ans;
    }

    private static boolean isPalindrome(int x) {
        if(x<0) return false;

        int reverseX=0, prev_rev = 0, original=x;
        while(x>0) {
            reverseX= reverseX*10 + x%10;
            if((reverseX - x%10)/10 != prev_rev) reverseX=0;
            x/=10;
            prev_rev = reverseX;
        }
        if(reverseX==original) return true;
        else return false;
    }

    // comparing 1st and last element and then modifying the integer
    private static boolean isPalindromeWithoutExtraSpace(int x) {
        if(x<0) return false;
        int div=1;
        while(x/div >=10) {
            div*=10;
        }
        while(x!=0) {
            int l = x/div;
            int r = x%10;
            if(l!=r) return false;
            x = (x%div)/10;
            div/=100;
        }
        return true;
    }

    private static boolean isMatch(String s, String regex) {

       // base case
        if(regex.length()==0) return (s.length()==0);

        // special case, regex has one character
        if(regex.length()==1) {
            if(s.length()<1) return false;
            else if(s.charAt(0)!=regex.charAt(0) && regex.charAt(0)!='.') return false;
            else return isMatch(s.substring(1), regex.substring(1));
        }

        // if regex's second character is not *
        if(regex.charAt(1)!='*') {
            if(s.length()<1) return false;
            if(s.charAt(0)!=regex.charAt(0)&&regex.charAt(0)!='.') return false;
            else return isMatch(s.substring(1), regex.substring(1));
        }

        // regex's second char is *
        else {
            // it means no occurrences of preceding character
            if(isMatch(s, regex.substring(2))) return true;


            // it means one or more occurrences of preceding char
            int i=0;
            while(i<s.length() && (s.charAt(i)==regex.charAt(0)||regex.charAt(0)=='.')) {
                if(isMatch(s.substring(i+1), regex.substring(2))) return true;
                i++;
            }
        }
        return false;
    }

    private static int maxArea(int[] height) {
        int n = height.length;
        if(n<2) return 0;
        int[][] matrix = new int[n][n];
        int maxArea = 0;
        for(int i=0; i<height.length-1;i++) {
            for(int j=0;j<height.length;j++) {
                if(i<j) {
                    int bigger = height[i]>height[j]?height[j]:height[i];
                    if(maxArea<bigger*(Math.abs(i-j)))
                    maxArea = bigger*(Math.abs(i-j));
                    matrix[i][j]=bigger*(Math.abs(i-j));
                    matrix[j][i]=bigger*(Math.abs(i-j));
                }
            }
        }
        return maxArea;
    }

    private static int maxAreaFaster(int[] height) {
        int maxArea = 0, n=height.length;
        int i=0, j=n-1;
        while(i<j) {
            int bigger = height[i]>height[j]?height[j]:height[i];
            if(maxArea<bigger*(Math.abs(i-j)))
                maxArea = bigger*(Math.abs(i-j));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxArea;
    }

    private static boolean containsPrefix(String[] arr, int n, String str, int start, int end) {
        for(int i=0;i<n;i++) {
            for(int j=start;j<=end;j++) {
                if(arr[i].charAt(j)!=str.charAt(j)) return false;
            }
        }
        return true;
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs.length<1) return "";
        String lowestCommonPrefix = "";
        int length = strs[0].length();
        for(int i=1;i<strs.length;i++) {
            if(length>strs[i].length()) {
                length = strs[i].length();
            }
        }
        int low = 0, high = length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(containsPrefix(strs, strs.length, strs[0], low, mid)) {
               lowestCommonPrefix = lowestCommonPrefix + strs[0].substring(low, mid+1);
               low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return lowestCommonPrefix;

    }

    private static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        if(n<3) return result;
        for(int i=0;i<n-2;i++) {
            for(int j=i+1;j<n-1;j++) {
                for(int k=j+1;k<n;k++) {
                    if(i<j && i<k && j<k) {
                        if(nums[i]+nums[j]+nums[k]==0) {
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                            list= new ArrayList<>();
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> threeSumFaster(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        if(n<3) return result;
        for(int i=0;i<n-2;i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i + 1, r = n - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[i] == 0) {
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        list = new ArrayList<>();
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] + nums[i] > 0) r--;
                    else l++;
                }
            }
        }
        return result;
    }

    private static int threeSumClosest(int[] nums, int target) {
        return 0;
    }


    public static void main(String[] args) {
//        int[] nums = {0, 0, 0, 0};
//        List<List<Integer>> ans = threeSumFaster(nums);

        int[] a = {1, 2, 3};
        int[][] b = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int brows = 3;
        int bcols = 3;
        int sum = 0;

        for(int i=0;i<brows;i++) {
            sum = a[i];
            for(int j=i+1;j<bcols;j++) {
                b[i][j] = sum + a[j];
                sum = b[i][j];
            }
        }

        int test = 100;


//        String[] arr = {"kilol"};
//        String longestCommonPrefix = longestCommonPrefix(arr);
//        int[] height = {1, 2};
//        int ans = maxAreaFaster(height);

     //   boolean ans = isMatch("a", ".*..a");

      //  boolean isPalindrome = isPalindromeWithoutExtraSpace(1223221);

       // int ans = atoi("-2147483649");

      //  int reverse = reverse(Integer.MAX_VALUE);

       // zigZagConversion("abc", 1);

       // String lps = lps("kilol");

//        int[] a1 = {1, 3};
//        int[] a2 = {2};
//        double result = merge(a1, a2);

//        String s = "abcdca";
//        int max_len = lengthOfLongestNRCS(s);
//        ListNode node1 = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(6);
//        ListNode node5 = new ListNode(6);
//        node1.next = node2;
//        node2.next=node3;
//        node3.next = null;
//        node4.next=node5;
//        node5.next=null;
//        ListNode result = addTwoNumbers(node1, node4);
    }
}
