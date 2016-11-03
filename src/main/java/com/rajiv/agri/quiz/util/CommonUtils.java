/**
 * 
 *//*
package com.rajiv.agri.quiz.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.rajiv.controller.LoadJsonController;
import com.test.rajiv.utils.CommonUtils;

*//**
 * @author 172661
 *
 *//*
public class CommonUtils {
	private static final String STR_CLASS_NAME = "CommonUtils";
	private static CommonUtils utils = new CommonUtils();
	final static LogManager utillogger = LoggerFactory.getLogger(LoadJsonController.class);
	
	public static CommonUtils getInstance() {
		return utils;
	}
	
	public String getFileContent(InputStream inputStream) throws Exception{
		 final String strMethodName = "getFileContent";
		 StringBuffer sb = new StringBuffer();
		    try {
		        
		        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
		        String strLine;
		        while ((strLine = br.readLine()) != null) {
		            sb.append("\n" + strLine);
		        }
		    } catch (FileNotFoundException e) {
		    	utillogger.info(strMethodName, "FileNotFoundException[" + e.toString() + "]");
		    	throw e;
		    } catch (IOException e) {
		    	utillogger.info(strMethodName, "IOException[" + e.toString() + "]");
		    	throw e;
		    }catch (Exception e) {
				utillogger.info(strMethodName, "Exception[" + e.toString() + "]");
		    	throw e;
		    }
		    return sb.toString();	    
		}
}
*/