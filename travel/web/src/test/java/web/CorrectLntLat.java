package web;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.weiminw.business.managers.HotelManager;
import com.weiminw.travel.interfaces.IHotel;
import com.weiminw.travel.interfaces.IHotelManager;
import com.weiminw.travel.persistence.impls.pos.HotelPO;

public class CorrectLntLat {
	public class ResultWrapper {
		public String status;
		public Map<String,Object> result;
	}
	static CloseableHttpClient httpclient = HttpClients.createDefault();
	
	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException  {
		// TODO Auto-generated method stub
		IHotelManager manager = HotelManager.create();
		for(IHotel hotel:manager.getHotels()){
			HotelPO po = (HotelPO) hotel;
			try {
				Map<String,Double> lntlat = getLngLat(hotel.getAddress());
				if(lntlat!=null){
					po.setLatitude(lntlat.get("lng"));
					po.setLatitude(lntlat.get("lat"));
					manager.updateHotel(po);
//					System.out.println("id = "+hotel.getId()+",lng = "+lntlat.get("lng")+",lat = "+lntlat.get("lat"));
				}
				else {
					System.out.println("id = "+hotel.getId()+",address = "+hotel.getName());
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		System.out.println(CorrectLntLat.getLngLat("北京方恒假日"));
	}
	
	public static Map<String,Double> getLngLat (String address) throws URISyntaxException, ClientProtocolException, IOException{
		
		URIBuilder builder = new URIBuilder("http://api.map.baidu.com/geocoder");
		builder.addParameter("output", "json").addParameter("key", "vnWOlOtrAtGQYENrRmwr0KjK").addParameter("address", address);
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse response = httpclient.execute(getMethod);
		String responseString = EntityUtils.toString(response.getEntity(), "GBK");
		System.out.println(responseString);
		Gson gson = new Gson();
		Map<String,Object> result = gson.fromJson(responseString,ResultWrapper.class).result;
		if (result == null||result.isEmpty()){
			return null;
		}
		Map<String,Double> lntlat = (Map<String,Double>)gson.fromJson(responseString,ResultWrapper.class).result.get("location");
		return lntlat;
	}

}
