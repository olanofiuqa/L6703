package com.MacmillanProjects.utilityclass;

import org.apache.commons.lang3.RandomStringUtils;



public class GenerateData {



    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }




    public String generateRandomAlphaNumeric(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String generateStringWithAllobedSplChars(int length,String allowdSplChrs){
        String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                allowdSplChrs;
        return RandomStringUtils.random(length, allowedChars);
    }

    public String generateEmail(int length) {
        String allowedChars=
                "0123456789abc" ;
        String email="";
        String temp=RandomStringUtils.random(length,allowedChars);
        email= "company"+temp.substring(0,temp.length()-4)+"@test.com";
        return email;
    }

    public String generateUrl(int length) {
        String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                "_-.";   //special characters
        String url="";
        String temp=RandomStringUtils.random(length,allowedChars);
        url= "www." +temp.substring(0,3)+temp.substring(4,temp.length()-4)+temp.substring(temp.length()-3) +".com" ;
        return url;
    }

// my own generated ones ....

    public  String generateCompanyName (int length) {
            String allowedChars=
                    "1234567890" ;
            String  companyName ="";
            String temp = RandomStringUtils.random( length, allowedChars );
            companyName = "Company"+ temp.substring(0,temp.length()-6);
            return companyName;
        }


}
