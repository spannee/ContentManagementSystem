package com.igate.isr.decorator;

import org.displaytag.decorator.TableDecorator;

import com.igate.isr.dto.ViewProblemSolutionDTO;

public class ViewProblemSolutionDecorator extends TableDecorator {
	ViewProblemSolutionDTO viewProbSolDTO = null;
	public String getSolution() {
		

		viewProbSolDTO = new ViewProblemSolutionDTO();
		viewProbSolDTO = (ViewProblemSolutionDTO) getCurrentRowObject();

		String solution = "<textarea readonly cols=\"70\" rows=\"5\">"
				+ viewProbSolDTO.getSolution() + "</textarea>";

		return solution;
	}

	public String getProblemStatement() {
		

		viewProbSolDTO = new ViewProblemSolutionDTO();
		viewProbSolDTO = (ViewProblemSolutionDTO) getCurrentRowObject();

		String problemStatement = "<textarea readonly cols=\"40\" rows=\"5\">"
				+ viewProbSolDTO.getProblemStatement() + "</textarea>";

		return problemStatement;
	}
}
