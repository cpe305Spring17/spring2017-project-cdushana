package com.telos.christianaushana.telos;

/**
 * Created by christianaushana on 5/18/17.
 */

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
  public static ArrayList<Goal> list = null;

  private static class GsonClass {
    ArrayList<Goal> gList = new ArrayList<>();
    public GsonClass(ArrayList<Goal> list) {
      gList = list;
    }
  }

  public static void writeDataToFile(Context context) {
    GsonClass gsonClassObj = new GsonClass(list);
    Gson gson = new Gson();

    String json = gson.toJson(gsonClassObj);
    try {
      FileWriter fileWriter = new FileWriter(context.getFilesDir() + "/" + "file");
      fileWriter.write(json);
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void readDataFromFile(Context context) throws IOException {
    GsonClass gsonClassObj = null;
    Gson gson = new Gson();

    BufferedReader bufferedReader = new BufferedReader(new FileReader(context.getFilesDir() + "/" + "file"));
    gsonClassObj = gson.fromJson(bufferedReader, GsonClass.class);

    if(gsonClassObj.gList == null)
      list = new ArrayList<>();
    else
      list = gsonClassObj.gList;

    bufferedReader.close();
  }
}
