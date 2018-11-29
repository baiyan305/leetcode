// 744. Find Smallest Letter Greater Than Target

public class FindSmallestLetterGreaterThanTarget {

    public void run() {
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters, 'a'));
        System.out.println(nextGreatestLetter(letters, 'c'));
        System.out.println(nextGreatestLetter(letters, 'd'));
        System.out.println(nextGreatestLetter(letters, 'g'));
        System.out.println(nextGreatestLetter(letters, 'j'));
        System.out.println(nextGreatestLetter(letters, 'k'));
        System.out.println("123");
    }


    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1;

        while(low < high) {
            int mid = low + (high-low)/2;
            if(target >= letters[mid]) low = mid + 1;
            else high = mid;
        }

        return letters[low] > target ? letters[low] : letters[0];
    }
	
}