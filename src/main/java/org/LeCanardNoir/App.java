package org.LeCanardNoir;

import org.LeCanardNoir.Observer.DisplayCurrent;
import org.LeCanardNoir.Observer.DisplayStats;
import org.LeCanardNoir.Observer.MeteoData;

import java.io.IOException;

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
        System.out.println("notify 1: \n");
        md.setData(30, 20, 90);
        System.out.println("notify 2: \n");
        md.setData(20, 50, 100);
        System.out.println("notify 3: \n");
        md.setData(10, 70, 50);
        System.out.println("notify 4: \n");
        md.setData(-30, 50, 75);

        dc.update(md, new Object(){float temperature = 99; float humidity = 99; float pression = 99;});
    }
}
