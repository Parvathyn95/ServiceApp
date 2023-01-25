package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility {
	Faker faker = new Faker();
	FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
	String firstName=faker.name().firstName();
	String abc=faker.address().cityName();
	String phNo=faker.phoneNumber().cellPhone();
	String email = fakeValuesService.bothify("????##@gmail.com");
	String x = fakeValuesService.bothify("##########");

}
