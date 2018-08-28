import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.commons.math3.util.Pair;

import io.reactivex.Maybe;
import io.reactivex.functions.Function;
import io.reactivex.observables.*;

public class QueryTvSales {

	public static void main(String[] args) {
		List<Pair<String, Integer>> sales = new ArrayList<>();
		
		sales.add(Pair.create("TV", 2500));
		sales.add(Pair.create("Camera", 1000));
		sales.add(Pair.create("TV", 3000));
		sales.add(Pair.create("Phone", 800));
		
		Maybe<Integer> tvSales = io.reactivex.Observable.fromIterable(sales)
				.filter(sale -> "TV".equals(sale.getKey()))
				.map(sale -> sale.getValue())
				.reduce((sale1, sale2) -> sale1 + sale2);
		
		tvSales.subscribe(tot -> System.out.println("TV Sales: $"+tot));
	}

}
