package com.mcweather.app.util;

import java.util.List;

import android.text.TextUtils;

import com.mcweather.app.db.McWeatherDB;
import com.mcweather.app.model.City;
import com.mcweather.app.model.County;
import com.mcweather.app.model.Province;

public class Utility {
	/**
	 *  解析和处理服务器返回的省级数据
	 * @param mcWeatherDB
	 * @param response
	 * @return
	 */
	public synchronized static boolean handleProvincesResponse(McWeatherDB mcWeatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			List<Province> provinces = XmlUitl.getProvinces(response);
			if(provinces != null && provinces.size() >0){
				for (Province province : provinces) {
					mcWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * 解析和处理服务器返回的市级数据
	 * @param mcWeatherDB
	 * @param response
	 * @param provinceId
	 * @return
	 */
	public static boolean handleCitiesResponse(McWeatherDB mcWeatherDB,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			List<City> cities = XmlUitl.getCities(response);
			if(cities != null && cities.size() >0){
				for (City city : cities) {
					city.setProvinceId(provinceId);
					mcWeatherDB.saveCity(city);
				}
				return true;
			}
			
		}
		return false;
	}
	/**
	 * 解析和处理服务器返回的县级数据
	 * @param mcWeatherDB
	 * @param response
	 * @param cityId
	 * @return
	 */
	public static boolean handleCountiesResponse(McWeatherDB mcWeatherDB,String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			List<County> counties = XmlUitl.getCounties(response);
			if(counties != null && counties.size() >0){
				for (County county : counties) {
					county.setCityId(cityId);
					mcWeatherDB.saveCounty(county);
				}
				return true;
			}
			
		}
		return false;
	}
	
}
