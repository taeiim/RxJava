import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Gugudan {

	public void plainJava() {
		int dan = inputDan();
		
		for(int row = 1; row<=9; ++row) {
			System.out.println(dan+"*"+row+"="+dan*row);
		}
	}
	
	public void reactiveV1() {
		int dan = inputDan();
		
		Observable<Integer> source = Observable.range(2, 9);
		source.subscribe(row -> System.out.println(dan+"*"+row+"="+dan*row));
	}
	
	public void reactiveV2() {
		int dan = inputDan();
		int a = 2;
		
		Function<Integer, Observable<String>> gugudan = num ->
			Observable.range(1,9).map(row -> num + "*" + row + "=" + dan*row);
		Observable<String> source = Observable.just(dan).flatMap(gugudan);
		source.subscribe(System.out::println);
	}
	
	public void reactiveV3() {
		int dan = inputDan();
		
		Observable<String> source = Observable.just(dan)
				.flatMap(num->Observable.range(1, 9))
				.map(row -> dan + "*" + row +"="+dan*row);
		source.subscribe(System.out::println);
	}
	
	public static int inputDan() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		
		return dan;
	}
	
	public static void main(String[] args) {
		Gugudan gugudan = new Gugudan();
		
//		gugudan.plainJava();
//		gugudan.reactiveV1();
		gugudan.reactiveV2();
		gugudan.reactiveV3();
	}

}
