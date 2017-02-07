package com.util.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JSONParse {

	public static void main(String[] args) {

		try {
			String url = "https://www.google.com/finance/info?q=NSE%3AKTKBANK%2CLICHSGFIN%2CLT%2CLUPIN%2CMARICO%2CMARUTI%2CMCDOWELL-N%2CMCLEODRUSS%2CMINDTREE%2CMOTHERSUMI%2CMRF%2CNCC%2CNHPC%2CNMDC%2CNTPC%2COFSS%2COIL%2CONGC%2CORIENTBANK%2CPAGEIND%2CPCJEWELLER%2CPETRONET%2CPFC%2CPIDILITIND%2CPNB%2CPOWERGRID%2CPTC%2CRCOM%2CRECLTD%2CRELCAPITAL%2CRELIANCE%2CRELINFRA%2CRPOWER%2CSAIL%2CSBIN%2CSIEMENS%2CSKSMICRO%2CSOUTHBANK%2CSRF%2CSRTRANSFIN%2CSTAR%2CSUNPHARMA%2CSUNTV%2CSYNDIBANK%2CTATACHEM%2CTATACOMM%2CTATAELXSI%2CTATAGLOBAL%2CTATAMOTORS%2CTATAMTRDVR%2CTATAPOWER%2CTATASTEEL%2CTCS%2CTECHM%2CTITAN%2CTORNTPHARM%2CTV18BRDCST%2CTVSMOTOR%2CUBL%2CUCOBANK%2CULTRACEMCO%2CUNIONBANK%2CUNITECH%2CUPL%2CVEDL%2CVOLTAS%2CWIPRO%2CWOCKPHARMA%2CYESBANK%2CZEEL";
			URL stockJson = new URL(url); // URL
																							// to
																							// Parse
			URLConnection urlConn = stockJson.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

			StringBuffer output = new StringBuffer();
			String inputLine;;
			while ((inputLine = in.readLine()) != null) {
				output.append(inputLine);
			}
            
			in.close();
			System.out.println(output.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
