package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);

		Hello hello = new Hello();
		hello.setData("hello"); // 이 부분을 main 메소드 안으로 이동
		String data = hello.getData();
		System.out.println(data);
	}
}
