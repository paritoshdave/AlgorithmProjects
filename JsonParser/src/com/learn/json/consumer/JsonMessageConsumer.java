package com.learn.json.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learn.json.domain.Entty;

import java.io.*;

/**
 * Created by Paritosh Dave on 4/29/2016.
 */
public class JsonMessageConsumer implements Consumer {

    @Override
    public Object consume() {

        Entty entObj = null;

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("D:\\JavaProjects\\JsonParser\\data.json"));

            while ((sCurrentLine = br.readLine()) != null) {
                Gson gson = new GsonBuilder().create();
                entObj = gson.fromJson(sCurrentLine, Entty.class);
                System.out.println("Reading JSON messages from file and pasring to java object.\n"+entObj.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return entObj;
    }

    public static void main(String[] args) {
        Consumer mesagConsumer = new JsonMessageConsumer();
        mesagConsumer.consume();
    }
}
