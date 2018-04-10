package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;



public class ExamlistExcelReader {
	
	public void hwpToTxt(String inputFilePath, String outfutFilePath)
	{
	    try {
//		InputStream input=new FileInputStream(new File("c:\\hwp\\sample.hwp"));
	//   OutputStream output = new FileOutputStream("c:\\hwp\\sample.txt");
	    InputStream input=new FileInputStream(new File(inputFilePath));
	    OutputStream output = new FileOutputStream(outfutFilePath);
	    
	    ContentHandler handler = new BodyContentHandler(new OutputStreamWriter(output, "UTF-8"));
	    Metadata metadata = new Metadata();
	    ParseContext context = new ParseContext();
	    Parser parser = new AutoDetectParser();

	    parser.parse(input,handler,metadata,context);
	        
	    System.out.println("title => " + metadata.get(TikaCoreProperties.TITLE));
	    System.out.println("creator => " + metadata.get(TikaCoreProperties.CREATOR));
	    System.out.println("keywords => " + metadata.get(TikaCoreProperties.KEYWORDS));
	    System.out.println("description => " + metadata.get(TikaCoreProperties.DESCRIPTION));
	    System.out.println("comments => " + metadata.get(TikaCoreProperties.COMMENTS));
	    // Alfresco 에서 한글문서의 문서정보에서 날짜가 날짜 형식에 맞지 않으면 error 를 발생해서
	    // TikaCoreProperties.CREATED 는 사용하지 않고  hwp_create_time 로 대체해서 사용
	    // System.out.println("createtime => " + metadata.get(TikaCoreProperties.CREATED));
	    System.out.println("createtime => " + metadata.get("hwp_create_time"));
	    }catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    	
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
		
	
	
	
	
}
