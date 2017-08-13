package com.Project.Logic;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

@Configuration
public class ConfigClass {
 
	


	@Bean 
	public Platform platform(){
		   return Platform.NA;
		}
	
	@Bean
	public Summoner summoner() {
		return new Summoner ();
	}
	
	@Bean
	public ApiConfig config(){
		return new ApiConfig();
	}
	
	
	@Bean 
	public RiotApi	api() {
		return new RiotApi();
	}
	
	@Bean
	public Set<LeaguePosition> League (){
		Set<LeaguePosition> LeaguePosition = null;
		return   LeaguePosition ;
	}
}	
