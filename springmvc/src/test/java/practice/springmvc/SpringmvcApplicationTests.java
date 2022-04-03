package practice.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

// @RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringmvcApplication.class)
class SpringmvcApplicationTests {

	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		System.out.println("hi");
		if (applicationContext != null) {
			String[] beans = applicationContext.getBeanDefinitionNames();

			for (String bean : beans) {
				System.out.println("bean : " + bean);
			}
		}
	}
}
