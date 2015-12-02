package com.excise.JsonDemo.requestion.basic;

import java.io.*;

/**
 * Created by mgq on 2015/12/1.
 */
public class SerializationUtils {

    private static String FILE_NAME="e:/obj.bin";

    //序列化
    public static void writeObject(Serializable s){
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(
                    new FileOutputStream(FILE_NAME)
            );
            objectOutputStream.writeObject(s);
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //反序列化
    public static Object readObject(){
        Object obj=null;
        try {
            ObjectInput objectInput=new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj=objectInput.readObject();
            objectInput.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
