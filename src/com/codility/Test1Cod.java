package com.codility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test1Cod {
    static class CityDetails implements Comparable{
        private int serialNo;
        private String cityName;
        private Date dateTime;
        private String extension;
        public int getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Date getDateTime() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        @Override
        public int compareTo(Object o) {
            return getDateTime().compareTo(((CityDetails)o).getDateTime());
        }


    }
    public static void main(String[] args) throws ParseException {
        String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";
        String photoDetails[] = S.split("\n");
        int count = 1;
        List<CityDetails> cityDetailList = new ArrayList<>();
        for(String s:photoDetails){
            String cityDetailArray[] = s.split(", ");
            CityDetails cityDetails = new CityDetails();
            cityDetails.setSerialNo(count);
            cityDetails.setCityName(cityDetailArray[1]);
            DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=formatter.parse(cityDetailArray[2]);
            cityDetails.setDateTime(date);
            String extension = cityDetailArray[0].split("\\.")[1];
            cityDetails.setExtension(extension);
            cityDetailList.add(cityDetails);
        }
        Map<String,Long> cityCountMap = cityDetailList.stream()
                .collect(Collectors.groupingBy(CityDetails::getCityName, Collectors.counting()));
        Map<String, List<CityDetails>> cityMap= new HashMap<>();
        for(CityDetails city:cityDetailList){
            if(cityMap.containsKey(city.getCityName())){
                List cities = cityMap.get(city.getCityName());
                cities.add(city);
                Collections.sort(cities);
                cityMap.put(city.getCityName(), cities);
            }else{
                List cities = new ArrayList();
                cities.add(city);
                cityMap.put(city.getCityName(), cities);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(CityDetails city:cityDetailList){
            int numDigits = String.valueOf(cityCountMap.get(city.getCityName())).length();
            int indexOf = cityMap.get(city.getCityName()).indexOf(city);
            int indexLength = String.valueOf(indexOf).length();
            String extension = cityMap.get(city.cityName).get(indexOf).getExtension();
            if(numDigits>indexLength){
                char a[] = new char[numDigits-indexLength];
                Arrays.fill(a,'0');
                sb.append(city.getCityName()+new String(a)+indexOf+"."+extension);
            }else{
                sb.append(city.getCityName()+indexOf+"."+extension);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
