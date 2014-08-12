/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.CheckCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zfh1005
 */
public class CheckCodeFormat {

    public boolean checkSsidFormat(String ssid) {
        boolean result = false;
        if (ssid.contains("-5G")) {
            //check 5G SSID
            result = check5gSSID(ssid);
        } else {
            //check 2G SSID
            result = check2gSSID(ssid);
        }
        return false;
    }

    //passpharse format is: (a Adjectives from Adjectives) + a Nouns from Nouns) + three numbers
    public boolean checkPasspharseFormat(String paserpharse) {
        String temp;
        for (int i = 0; i < MaxNumber; i++) {
            temp = Adjectives[i] + Nouns[i];
            if (paserpharse.contains(temp)) {
                String tempString = paserpharse.substring(temp.length());
                Pattern pattern = Pattern.compile("\\d{3}$");
                Matcher matcher = pattern.matcher(tempString);
                if (matcher.find()) {
                    return true;
                } else {
                    //if the end three charater is not number,the compare will always failed.
                    break;
                }
            } else {
                continue;
            }
        }
        return false;
    }
    
    
    //2G SSID format is:"NETGEAR" + two numbers
    private boolean check2gSSID(String Ssid2g) {
        String temp = "^" + SsidKeyword + "\\d{2}" ; 
        Pattern pattern = Pattern.compile(temp);
        Matcher matcher = pattern.matcher(Ssid2g);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    //5G SSID format is:"NETGEAR" + two numbers + "-5G"
    private boolean check5gSSID(String Ssid5g) {
        String temp = "^" + SsidKeyword + "\\d{2}-5G" ; 
        Pattern pattern = Pattern.compile(temp);
        Matcher matcher = pattern.matcher(Ssid5g);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    //paserpharse used Adjectives, it define by customer
    private final String[] Adjectives = {
        "ancient", "aquatic", "basic", "black", "blue",
        "brave", "breezy", "bright", "calm", "cheerful",
        "classy", "clever", "cloudy", "crispy", "curly",
        "daily", "delightful", "dizzy", "dynamic", "elated",
        "elegant", "excited", "exotic", "fancy", "fearless",
        "festive", "fluffy", "fresh", "friendly", "fuzzy",
        "gentle", "gigantic", "graceful", "grand", "great",
        "green", "happy", "heavy", "helpful", "husky",
        "icy", "imaginary", "jagged", "jolly", "joyous",
        "kind", "large", "little", "lively", "lucky",
        "magical", "melodic", "mighty", "misty", "modern",
        "narrow", "new", "nifty", "noisy", "odd",
        "orange", "pastel", "perfect", "phobic", "pink",
        "precious", "purple", "quaint", "quick", "quiet",
        "rapid", "red", "rocky", "round", "royal",
        "rustic", "shiny", "silent", "silky", "silly",
        "smiling", "slow", "smooth", "strong", "sunny",
        "sweet", "thirsty", "tiny", "thoughtful", "uneven",
        "unusual", "vanilla", "vast", "watery", "wide",
        "witty", "wonderful", "yellow", "young", "zany"
    };

    //paserpharse used Nouns, it define by customer
    private final String[] Nouns = {
        "airplane", "apple", "balloon", "banana", "breeze",
        "bird", "boat", "box", "bug", "butter",
        "cartoon", "canoe", "carrot", "cello", "chair",
        "cheese", "coconut", "comet", "curtain", "cream",
        "daisy", "diamond", "earth", "elephant", "fire",
        "flamingo", "flower", "flute", "giant", "grasshopper",
        "hat", "hill", "iris", "ink", "jade",
        "jungle", "kangaroo", "kayak", "lake", "lightning",
        "lotus", "mango", "mint", "moon", "mountain",
        "nest", "ocean", "onion", "octopus", "orchestra",
        "owl", "lotus", "mango", "phoenix", "piano",
        "pineapple", "planet", "pond", "potato", "prairie",
        "quail", "rabbit", "raccoon", "raven", "river",
        "road", "rosebud", "sea", "ship", "shoe",
        "shrub", "skates", "sky", "socks", "sparrow",
        "spider", "squash", "squirrel", "star", "street",
        "sun", "table", "teapot", "trail", "train",
        "tree", "tomato", "trumpet", "tuba", "tulip",
        "umbrella", "unicorn", "valley", "vase", "violet",
        "violin", "water", "window", "wind", "zoo"
    };

    private final int MaxNumber = 100;
    private final String SsidKeyword = "NETGEAR";
}
