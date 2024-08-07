package com.example.nagoyameshi.csv;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nagoyameshi.csvData.RestaurantCsvData;
import com.example.nagoyameshi.csvData.UserCsvData;
import com.example.nagoyameshi.entity.Restaurants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class CsvService {
	
	
    private final CsvMapper mapper;
    private  CsvSchema csvSchema;
    
    
    

  
    public CsvService(CsvMapper mapper, CsvSchema csvSchema) {
        this.csvSchema = csvSchema;
        this.mapper = mapper;
       
    }

    
   
//    userのrole情報の加工
    public String toStringeRoleId(Integer id)
    {
    	String roleString=null;
    	switch(id)
    	{
    	case 1:roleString="無料会員";
		break;
				
    	case 2:roleString="有料会員";
		break;
		
    	case 3:roleString="管理者";
		break;
    	}
    	
    	return roleString;
    }
    
    
    //会員CSV題名
    public CsvSchema getCsvHeaderUser()
    {
    	csvSchema=mapper.schemaFor(UserCsvData.class).withHeader();
    	return csvSchema;
    }
    
    //会員CSVボディ
    public String writeCsvTextUser(List<UserCsvData>csvdataList,CsvSchema csvSchema)
   throws JsonProcessingException
    {
    	return mapper.writer(csvSchema).writeValueAsString(csvdataList);
    }
    
    
    
//    カテゴリーの加工
    public String hasCategory(Restaurants restaurant)
    {
    	String categoryString=null;
    	
    	if(restaurant.getCategory()!=null)
    	{
    		categoryString=restaurant.getCategory().getName();
    	}
    	
    	return categoryString;
    }
    
    //店舗CSV題名
    public CsvSchema getCsvHeaderRestaurant()
    {
    	csvSchema=mapper.schemaFor(RestaurantCsvData.class).withHeader();
    	return csvSchema;
    }
    
    //店舗CSVボディ
    public String writeCsvTextRestaurant(List<RestaurantCsvData>csvdataList,CsvSchema csvSchema)
   throws JsonProcessingException
    {
    	return mapper.writer(csvSchema).writeValueAsString(csvdataList);
    }
    
    //	CSVフォームのダウンロード
    public void output(HttpServletResponse httpServletResponse)
    {
    	try(OutputStream os=httpServletResponse.getOutputStream();)
		{
				Path filePath=Path.of("src/main/resources/static/csvFile/CSVform.csv");
				byte[]fileBytes=Files.readAllBytes(filePath);
				
				 httpServletResponse.setContentType("application/octet-stream");
		           httpServletResponse.setHeader("Content-Disposition", "attachment; filename=CSVform.csv");
		           httpServletResponse.setContentLength(fileBytes.length);
		           os.write(fileBytes);
		           os.flush();
				
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
    }
}
