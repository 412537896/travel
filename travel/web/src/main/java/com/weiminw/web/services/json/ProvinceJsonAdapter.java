package com.weiminw.web.services.json;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.weiminw.travel.interfaces.IProvince;

public class ProvinceJsonAdapter extends TypeAdapter<IProvince> {
	@Override
	public IProvince read(JsonReader reader) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(JsonWriter writer, IProvince province)
			throws IOException {
		// TODO Auto-generated method stub
		if(province == null) {
			writer.nullValue();
			return;
		}
		writer.value(province.getProvinceName());
		
	}

	public final static Object newInstance() {
		// TODO Auto-generated method stub
		return new ProvinceJsonAdapter();
	}
}
