package exercise;

import org.apache.commons.lang3.StringUtils;

// BEGIN
class ReversedSequence implements CharSequence{
    private String text;

    public ReversedSequence(String text) {
        this.text = StringUtils.reverse(text);
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int i) {
        return text.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        if (i > text.length() || i1 > text.length() || i < 0 || i1 < 0) {
            throw new IndexOutOfBoundsException();
        }
       String result = "";
        char[] chars = text.toCharArray();
        for (int j = i; j < i1; j++) {
            result += chars[j];
        }
        return result;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
// END
