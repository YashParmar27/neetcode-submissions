class Solution {

    // Take the list of strings, add a number for the length of the word
    // Append the word afterwards
    // Repeat untill all words are done
    // Decoder reads the number and converts those many strings 
    // into a word and adds to result.

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs)
        {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        int i = 0;

        while (i < str.length())
        {   
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            
            int len = Integer.parseInt(str.substring(i, j));

            strs.add(str.substring(j + 1, j + 1 + len));
            i = j + len + 1;
        }
        
        return strs;
    }
}
