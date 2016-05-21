package com.lgb.wechat.arc.util.api.json.tq;

import java.util.List;

public class Results {
    private String currentCity;
    private String pm25;
    private List<Index> index;
    private List<WeatherData> weather_data;

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public void setIndex(List<Index> index) {
        this.index = index;
    }

    public void setWeather_data(List<WeatherData> weather_data) {
        this.weather_data = weather_data;
    }

    public String getCurrentCity() {

        return currentCity;
    }

    public String getPm25() {
        return pm25;
    }

    public List<Index> getIndex() {
        return index;
    }

    public List<WeatherData> getWeather_data() {
        return weather_data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("城市: ").append(getCurrentCity()).append(".\n")
                .append("PM2.5: ").append(getPm25()).append(".\n");

        for (Index index : getIndex()) {
            builder.append(index.toString());
        }

        for (WeatherData wd : getWeather_data()) {
            builder.append(wd.toString());
        }

        return builder.toString();
    }
}
