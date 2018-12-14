package model;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = "classpath:Features", tags = "@FilmeTeste",
	glue = "br.com.ingresso.model.passos", monochrome = true, dryRun = false)

	public class FilmeTest {	


}
