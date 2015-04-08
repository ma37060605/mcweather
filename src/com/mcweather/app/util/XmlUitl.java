package com.mcweather.app.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.mcweather.app.model.City;
import com.mcweather.app.model.County;
import com.mcweather.app.model.Province;

public class XmlUitl {
	public static List<Province> getProvinces(String response){
		List<Province> provinces = null;
		Province province = null;
		XmlPullParser parser = Xml.newPullParser();
		try {
			parser.setInput(new StringReader(response));
			int eventType = parser.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT){
				String nodeName = parser.getName();
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					provinces = new ArrayList<Province>();
					break;
				case XmlPullParser.START_TAG:
					if("city".equals(nodeName)){
						province = new Province();
						String provinceName = parser.getAttributeValue(null, "quName");
						province.setProvinceName(provinceName);
						String provinceCode = parser.getAttributeValue(null, "pyName");
						province.setProvinceCode(provinceCode);
					}
					break;
				case XmlPullParser.END_TAG:
					if("city".equals(nodeName)){
						provinces.add(province);
						province = null;
					}
					break;
				default:
					break;
				}
				eventType = parser.next();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return provinces;
	}
	
	public static List<City> getCities(String response){
		List<City> cities = null;
		City city = null;
		XmlPullParser parser = Xml.newPullParser();
		try {
			parser.setInput(new StringReader(response));
			int eventType = parser.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT){
				String nodeName = parser.getName();
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					cities = new ArrayList<City>();
					break;
				case XmlPullParser.START_TAG:
					if("city".equals(nodeName)){
						city = new City();
						String cityName = parser.getAttributeValue(null, "cityname");
						city.setCityName(cityName);
						String cityCode = parser.getAttributeValue(null, "pyName");
						city.setCityCode(cityCode);
					}
					break;
				case XmlPullParser.END_TAG:
					if("city".equals(nodeName)){
						cities.add(city);
						city = null;
					}
					break;
				default:
					break;
				}
				eventType = parser.next();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return cities;
	}
	
	public static List<County> getCounties(String response){
		List<County> counties = null;
		County county = null;
		XmlPullParser parser = Xml.newPullParser();
		try {
			parser.setInput(new StringReader(response));
			int eventType = parser.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT){
				String nodeName = parser.getName();
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					counties = new ArrayList<County>();
					break;
				case XmlPullParser.START_TAG:
					if("city".equals(nodeName)){
						county = new County();
						String countyName = parser.getAttributeValue(null, "cityname");
						county.setCountyName(countyName);
						String countyCode = parser.getAttributeValue(null, "pyName");
						county.setCountyCode(countyCode);
					}
					break;
				case XmlPullParser.END_TAG:
					if("city".equals(nodeName)){
						counties.add(county);
						county = null;
					}
					break;
				default:
					break;
				}
				eventType = parser.next();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return counties;
	}
}


