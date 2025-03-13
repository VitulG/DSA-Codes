package com.assignment.flipkart_daily;

import com.assignment.flipkart_daily.exceptions.ItemCreationException;
import com.assignment.flipkart_daily.models.Item;
import com.assignment.flipkart_daily.repositories.ItemRepository;
import com.assignment.flipkart_daily.services.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class FlipkartDailyApplicationTests {

	@Test
	void contextLoads() {
	}


}
