package com.learn.json.publisher;

import com.google.gson.Gson;
import com.learn.json.domain.EntityType;
import com.learn.json.domain.Entty;
import com.learn.json.domain.Principal;
import com.learn.json.domain.PrincipalType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Paritosh Dave on 4/28/2016.
 */
public class JsonMessagePublisher implements Publisher {

    @Override
    public void publish(Object obj)
    {
        String jsonObj = convertToJson((Entty)obj);
        writeToFile(jsonObj);
    }

    private void writeToFile(String jsonObj)
    {
        System.out.println("Writing json objects to file");
        try {
            //write converted json data to a file named "file.json"
            FileWriter writer = new FileWriter("D:\\JavaProjects\\JsonParser\\data.json",true);
            writer.write(jsonObj+"\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // convert entity object to Json
    private String convertToJson(Entty entity)
    {
        return new Gson().toJson(entity);
    }

    public static void main(String[] args) {

        JsonMessagePublisher messgPublisher = new JsonMessagePublisher();

        List<Entty> listOfEntity = messgPublisher.populateListOfEntObj();

        // To print
        listOfEntity.forEach( (a) ->
        {
            // System.out.println(a.toString());
            messgPublisher.publish(a);
        });
    }

    private List<Entty> populateListOfEntObj()
    {
        List<Entty> listOfEntity = new ArrayList<Entty>();

        Entty e1 = new Entty(1, "Paritosh", EntityType.INDIVIDUAL);
        e1.setDob( new GregorianCalendar());
        Principal p1 = new Principal(101, "Namrata", PrincipalType.INDIVIDUAL);
        Principal p2 = new Principal(102, "Neeraj", PrincipalType.INDIVIDUAL);
        Principal p3 = new Principal(103, "FaceBook", PrincipalType.ORGANIZATION);
        e1.setPrincipals(new Principal[]{p1,p2,p3});
        listOfEntity.add(e1);

        Entty e2 = new Entty(2, "GS", EntityType.ORGANIZATION);
        Principal p6 = new Principal(106, "FaceBook", PrincipalType.ORGANIZATION);
        e2.setPrincipals(new Principal[]{p2,p6});

        listOfEntity.add(e2);

        return listOfEntity;
    }
}
