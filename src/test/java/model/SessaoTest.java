package model;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(features = "classpath:Features", tags = "@SessaoTeste",
			plugin = {"pretty", "html:target/cucumber"},
	glue = "br.com.ingresso.model.passos", monochrome = true, dryRun = false)
	public class SessaoTest {
	}
