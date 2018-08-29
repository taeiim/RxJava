
import java.util.concurrent.TimeUnit;
import java.util.*;
import io.reactivex.Observable;

public class IntervalExample {

	public void printNumbers() {
		Observable<Long> source = Observable.interval(1, TimeUnit.MINUTES)
				.map(num -> num+1)
				.take(5);
		source.subscribe(System.out::println);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntervalExample intervalExample = new IntervalExample();
		intervalExample.printNumbers();
	}

}
