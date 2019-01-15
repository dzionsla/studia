
public class Sort {
	public Sort(){
		int[] numbers = new int[] { 1230,22,0, 4, 2, 0, 2, 10, 1, 9, 12, 3, 5, 33, 4, 11, 44, 33,55,66,33,24,1 };
		
		sort(numbers);
        printNumbers(numbers);
	}
	
	public void printNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
	}
	
	public boolean isGreaterThan(int[] numbers, int x, int y) {
		return numbers[x] > numbers[y];
	}
	
	public void swap(int[] numbers, int x, int y) {
        int temp;
        temp = numbers[y];
        numbers[y] = numbers[x];
        numbers[x] = temp;
	}
	
	public void sort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
            	if (isGreaterThan(numbers, j, j+1)) {
            		swap(numbers, j, j+1);
            	}
            }
        }
	}
		
}