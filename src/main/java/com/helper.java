package com;

public class helper {

    public static String getDesc(String d)
    {
       String str[]=d.split(" ");
       if(str.length>10){
           String res="";
           for(int i=0;i<10;i++){
               res+=str[i]+" ";
           }
           return (res+"...");
       }
       else{
           return (d+"...");
       }
    }
    
}
