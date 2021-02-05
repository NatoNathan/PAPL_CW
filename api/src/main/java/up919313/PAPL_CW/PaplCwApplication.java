package up919313.PAPL_CW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class PaplCwApplication {

	public static void main(String[] args) {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		SpringApplication.run(PaplCwApplication.class, args);
	}

}
