package com.Project.Logic;



import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Platform;
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;


@Component
public class SummonerModel {

	final String key = "RGAPI-356d329a-41ca-4465-b222-20ab2f8b7e8c";
	
	@Autowired
	Platform platform;
	@Autowired
	Summoner Summoner;
	@Autowired
	ApiConfig config;
	@Autowired
	RiotApi	api;
	@Autowired
	Set<LeaguePosition> League;



	private int soloWins;
	private String username;
	private long id;

	private int soloLoss;

	private String soloQueue;

	private String soloTier;
	
	ArrayList<Object> Solo5V5 = new ArrayList<Object>();

	private String soloRank;
	
	
	
	
	
	
	public 	void setUsername (String username) {
		this.username = username;
	}
	
	public String getUsername () {
		return username;
	}
	

	public void setConfig () {
	
		config = new ApiConfig().setKey(key);
		api = new RiotApi(config);
	}
	
	
	
	
		
		
		
	
	public long getAccountID () throws RiotApiException{
		 Summoner = api.getSummonerByName(Platform.NA, username);
		 return id =  Summoner.getId();
	
	}
	
	public long getSummonerLevel () throws RiotApiException{
		Summoner = api.getSummonerByName(Platform.NA, username);
		return Summoner.getSummonerLevel();
	}
	
	public ArrayList<Object>  getSoloStats () throws RiotApiException {
		League = api.getLeaguePositionsBySummonerId(Platform.NA, id);
			for (LeaguePosition i : League) {
					if (i.getQueueType().equals("RANKED_SOLO_5x5")) {
						Solo5V5.add(0,soloQueue = i.getQueueType());
						Solo5V5.add(1,soloTier = i.getTier());
						Solo5V5.add(2,soloRank = i.getRank());
						Solo5V5.add(3,soloWins = i.getWins());
						Solo5V5.add(4,soloLoss = i.getLosses());
						Solo5V5.add(5,soloLoss+soloWins);
					}
				}
					return Solo5V5;
}


}
