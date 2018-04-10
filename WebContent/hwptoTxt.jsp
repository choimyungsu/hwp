<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, javax.naming.InitialContext, javax.naming.Context, java.util.List" %>
<%@ page import="com.excel.ExamlistExcelReader" %>

<%@ page import="java.io.PrintWriter, java.nio.charset.Charset, java.nio.file.Files, java.nio.file.Path, java.nio.file.Paths, java.nio.file.StandardOpenOption, java.util.Scanner" %>


</head>
<body>
<%

    
    ExamlistExcelReader excelReader = new ExamlistExcelReader();

    System.out.println("*****hwp  *****");
    System.out.println("*****realpath  *****"+ request.getSession().getServletContext().getRealPath("/"));
    
    
    excelReader.hwpToTxt("c:\\hwp\\9itn1804.hwp", "c:\\hwp\\9itn1804.txt");// 먼전 txt 로 변환 한뒤 
   
    /*
    // 2차적으로 csv 로 변환 
    final Path path = Paths.get("c:\\hwp\\", "", ""); // 경로를 맞줘줄 것 
    final Path txt = path.resolve("linux1703.txt");
    final Path csv = path.resolve("linux1703Convert.csv");
    final Charset utf8 = Charset.forName("UTF-8");
    try (
            final Scanner scanner = new Scanner(Files.newBufferedReader(txt, utf8));
            final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, utf8, StandardOpenOption.CREATE_NEW))) {
        while (scanner.hasNextLine()) {
             //System.out.println(scanner.findInLine("[1~100]"));
            pw.println(scanner.nextLine().replace('|', ','));
        }
    }catch(Exception e){
    	e.printStackTrace();
    }
    
    */

    out.println("정상적으로 변환되었습니다.");

    
%>

</body>
</html>

