package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath = "src/ru/gb/family_tree/writer/tree.txt";

    @Override
    public void save(Serializable serializable){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public Object read(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String path) {
    this.filePath = filePath;
    }
}
