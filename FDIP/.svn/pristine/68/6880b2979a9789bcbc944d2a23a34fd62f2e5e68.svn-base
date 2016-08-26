package com.trusdom.fdip.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: ResultVo 
* @Description: TODO(***)
* @author zjb 
* @date May 16, 2016 5:52:47 PM
* 
* @param <T>
 */
public class ResultVo<T> extends AbstractVo<ResultVo<T>>{

	protected List<T> results = new ArrayList<T>();
	
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> resultList) {
		this.results = resultList;
	}

	@Override
	public String toString() {
		return toJson().toString();
	}

}
