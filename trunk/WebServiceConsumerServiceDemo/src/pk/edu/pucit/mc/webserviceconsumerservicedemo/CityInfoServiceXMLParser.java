package pk.edu.pucit.mc.webserviceconsumerservicedemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class CityInfoServiceXMLParser {

	private static final String ns = null;
	
	public CityInfoDTO[] parse(InputStream is) throws XmlPullParserException, IOException{
		XmlPullParser parser = Xml.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(is, null);
        parser.nextTag();
        return readFeed(parser);
	}
	
	private CityInfoDTO[] readFeed(XmlPullParser parser) throws XmlPullParserException, IOException{
	    List<CityInfoDTO> cities = new ArrayList<CityInfoDTO>();
		parser.require(XmlPullParser.START_TAG, ns, "cities");
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        cities.add(readCity(parser));
	    }
	    CityInfoDTO [] citiesArray = new CityInfoDTO[cities.size()];
	    citiesArray = cities.toArray(citiesArray);
	    return citiesArray;
	}
	
	private CityInfoDTO readCity(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "city");
		int id = 0;
		String name = null;
		String countryCode = null;
		String district = null;
		int population = 0;
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String tagName = parser.getName();
	        if (tagName.equals("id")) {
	            id = Integer.parseInt(readTag(parser, "id"));
	        } else if (tagName.equals("name")) {
	            name = readTag(parser,"name");
	        } else if (tagName.equals("countryCode")) {
	        	countryCode = readTag(parser,"countryCode");
	        } else if (tagName.equals("district")) {
	        	district = readTag(parser,"district");
	        } else if (tagName.equals("population")) {
	        	population = Integer.parseInt(readTag(parser,"population"));
	        }
	    }
	    return new CityInfoDTO(id, name, countryCode, district, population);
	}
	
	private String readTag(XmlPullParser parser, String tagName) throws XmlPullParserException, IOException{
		parser.require(XmlPullParser.START_TAG, ns, tagName);
		String text = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, tagName);
		return text;		
	}
	
	private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
	    String result = "";
	    if (parser.next() == XmlPullParser.TEXT) {
	        result = parser.getText();
	        parser.nextTag();
	    }
	    return result;
	}
	
}
