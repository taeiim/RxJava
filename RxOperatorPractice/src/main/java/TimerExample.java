import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import commons.CommonUtils;
import commons.Log;
import io.reactivex.Observable;

public class TimerExample {

	public void showTime() {
		CommonUtils.exampleStart();
		Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS)
				.map(notUsed -> {
					return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
							.format(new Date());
				});
		source.subscribe(Log::it);
		
		// 메인 스레드가 아닌 계산 스케줄러에서 실행되기 때문에 
		// sleep() 안하면 메인스레드에서 할 일이 없기 때문에 프로그램이 바로 종료됨.
		CommonUtils.sleep(1000);
		 
	}
	
	public static void main(String[] args) {
		TimerExample timerExample = new TimerExample();
		timerExample.showTime();
	}

}
