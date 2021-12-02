package com.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/Destination/cucumber.json", "timeline:target/timelineFormatter"},
    features = {"classpath:features"},
    glue = {"com.stepdefs"},
    monochrome = true,
    strict = true,
    tags = {"not @issue"}
)

public class RunCucumberTest {
}