package com.alten.acc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 

@RunWith(SpringRunner.class)
@SpringBootTest
class AccCarClientApplicationTests {

	@Test
	void contextLoads() {
		AccCarClientApplication.main(new String[] {""});
		Assert.assertEquals("AccCarClientApplication", "AccCarClientApplication");
	}

}
