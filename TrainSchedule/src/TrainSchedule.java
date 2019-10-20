
/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

import java.io.FileWriter;
import java.util.Scanner;

import org.apache.sling.commons.json.JSONObject;
//import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @version $Id$
 */

public class TrainSchedule
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String trainNo = sc.next();
        String url = "https://enquiry.indianrail.gov.in/xyzabc/ShowTrainSchedule?trainNo=" + trainNo;
        Document document = Jsoup.connect(url).get();
        // System.out.println(document);
        Element trainTable = document.getElementById("trnSchDataTbl");
        // System.out.println(trainTable);
        Elements tableContent = trainTable.getElementsByTag("tr");
        
        for (Element trs : tableContent) {
            JSONObject obj = new JSONObject();
            Elements tds = trs.getElementsByTag("td");
            for (int i = 0; i < tds.size(); i++) {
                switch (i) {
                    case 0:
                        System.out.println("Execute");
                        obj.put("Id", tds.get(i).text());
                        break;
                    case 1:
                        obj.put("Station", tds.get(i).text());

                        break;
                    case 2:
                        obj.put("Schedule Day", tds.get(i).text());

                        break;
                    case 3:
                        obj.put("Sch Arr-Sch Dep", tds.get(i).text());

                        break;
                    case 4:
                        obj.put("Distance", tds.get(i).text());

                        break;
                }

            }
            /* try and catch block to handle all the errors
                and forbid them from failing the code.*/
            try (FileWriter file = new FileWriter("./json.txt", true)) {
                file.write(obj.toString(2));
                // System.out.println("\nJSON Object: " + obj);

            } catch (Exception e) {
                System.out.println("Hah! Error encountered.\n");
            }
        }
        System.out.println("Successfully Copied JSON Object to the file!");

    }
}
