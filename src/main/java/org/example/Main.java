package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        // This library helps us to do http request easily
/*        OkHttpClient client = new OkHttpClient();

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        Request request = new Request.Builder().url(url).build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                System.out.println("Something went wrong !!!");
            }
            System.out.println("Data : " + response.body().string());
        }catch (IOException ex){
            ex.printStackTrace();
        }*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService todoService = retrofit.create(TodoService.class);
        Todo t = todoService.getTodoById("1").execute().body();
        System.out.println("Todo object downloaded is : " + t.toString());
    }
}