package pebite.Ponitor_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PonitorBeApplication {

	static {
		System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
	} // 안해주면 서비스가 실행되는 시점에 약간의 지연이 발생


	public static void main(String[] args) {
		SpringApplication.run(PonitorBeApplication.class, args);
	}


}

