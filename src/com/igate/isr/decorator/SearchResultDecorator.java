package com.igate.isr.decorator;

import org.displaytag.decorator.TableDecorator;

import com.igate.isr.dto.SearchResultDTO;


public class SearchResultDecorator extends TableDecorator {

	public String getSolution()
	{
		SearchResultDTO srdto=null;

        srdto=new SearchResultDTO();
         srdto = (SearchResultDTO)getCurrentRowObject();
         
         String solution ="<textarea readonly cols=\"80\" rows=\"5\">"+srdto.getSolution()+"</textarea>";
         
         return solution;
	}
	public String getProblem()
	{
		SearchResultDTO srdto=null;

        srdto=new SearchResultDTO();
         srdto = (SearchResultDTO)getCurrentRowObject();
         
         String problem ="<textarea readonly cols=\"50\" rows=\"5\">"+srdto.getProblem()+"</textarea>";
         
         return problem;
	}
}
