package org.LeCanardNoir;

import org.LeCanardNoir.Observer.DisplayCurrent;
import org.LeCanardNoir.Observer.DisplayStats;
import org.LeCanardNoir.Observer.MeteoData;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        MeteoData md = new MeteoData();
        DisplayCurrent dc = new DisplayCurrent(md);
        DisplayStats ds = new DisplayStats(md);
        md.setData();
        md.setData();

    }
}
