package com.lgb.wechat.arc.util.api.json.tq;

public class WeatherData {
    private String date;
    private String dayPictureUrl;
    private String nightPictureUrl;
    private String weather;
    private String wind;
    private String temperature;

    public void setDate(String date) {
        this.date = date;
    }

    public void setDayPictureUrl(String dayPictureUrl) {
        this.dayPictureUrl = dayPictureUrl;
    }

    public void setNightPictureUrl(String nightPictureUrl) {
        this.nightPictureUrl = nightPictureUrl;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDate() {

        return date;
    }

    public String getDayPictureUrl() {
        return dayPictureUrl;
    }

    public String getNightPictureUrl() {
        return nightPictureUrl;
    }

    public String getWeather() {
        return weather;
    }

    public String getWind() {
        return wind;
    }

    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append(getDate()).append(" : ").append(getWeather()).append(", ")
                .append("风力 : ").append(getWind())
                .append("气温 : ").append(getTemperature())
                .append(".\n");

        return builder.toString();
    }
}
