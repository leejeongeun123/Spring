package co.company.spring;

import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.company.spring.controller.SlipVO;

public class JacksonTest {

	@Test
	public void test1() {
		ObjectMapper mapper = new ObjectMapper();
		String str = "[{\"slipAmount\":15246,\"salDt\":\"20210107\",\"customer\":\"149\",\"bankAcct\":\"11\"},{\"slipAmount\":17303,\"salDt\":\"20210107\",\"customer\":\"174\",\"bankAcct\":\"111\"},{\"slipAmount\":12487,\"salDt\":\"20210107\",\"customer\":\"176\",\"bankAcct\":\"1111\"}]";
		try {
			JsonNode node = mapper.readTree(str);
			System.out.println(node.get(0).path("slipAmount"));
			
			SlipVO[] list =
					mapper.readValue(str, SlipVO[].class);
			System.out.println(list[0].getSlipAmount());
			URL url = new URL("http://kobis.or.kr/kobiso");
			JsonNode movie = mapper.readTree(url);
			System.out.println(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
