package com.weiminw.web.services.json;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.weiminw.travel.interfaces.ICity;

public class CityJsonAdapter extends TypeAdapter<ICity> {
	@Override
	public ICity read(JsonReader reader) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(JsonWriter writer, ICity city) throws IOException {
		// TODO Auto-generated method stub
		if(city == null){
			writer.nullValue();
			return;
		}
		writer.value(city.getCityName());
		
	}
	
	public final static CityJsonAdapter newInstance(){
		return new CityJsonAdapter();
	}
}
