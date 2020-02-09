package com.nt;



import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.nt.domain.Book;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringBootConsumerCloudApplication {
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(SpringBootConsumerCloudApplication.class);

	@StreamListener("input")
    public void consumerMsg(Book book) {
   	logger.info("Consume payload:"+book);
		System.out.println(book);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsumerCloudApplication.class, args);
	}

}
