package com.alten.acc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccCustomerCarApplicationTests {

	@Test
	void contextLoads() {
		AccCustomerCarApplication.main(new String[] { "" });
		assertEquals("AccCustomerCarApplication", "AccCustomerCarApplication");
	}
	

}
