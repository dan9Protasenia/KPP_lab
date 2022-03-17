package com.example.demo;

import com.example.demo.service.Calculation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void isEvenEqualsTrue() {
		var tempObj = new Calculation();
		boolean even = tempObj.isEven(10);
		assert even;
	}
	@Test
	void isSimpleEqualsTrue() {
		var tempObj = new Calculation();
		boolean even = tempObj.isSimple(3);
		assert even;
	}


}
