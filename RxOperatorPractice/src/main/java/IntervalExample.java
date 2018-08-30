import java.util.concurrent.TimeUnit;

import commons.CommonUtils;
import commons.Log;

import io.reactivex.Observable;

public class IntervalExample {

	public void printNumbers() {
		CommonUtils.exampleStart();

		Observable<Long> source = Observable.interval(0, 1L, TimeUnit.MILLISECONDS)
				.map(num -> (num+1))
				.take(5);
		source.subscribe(Log::it);
		
		Log.it("ddd");
		Log.it("ddd");
		
		CommonUtils.sleep(1000);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntervalExample intervalExample = new IntervalExample();
		intervalExample.printNumbers();
	}

}
