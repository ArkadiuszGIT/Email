package com.barosanu.controller.services;
/**
 * Created by Arek on 06.04.2020.
 */
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FolderUpdaterService extends Service {

    private List<Folder> folderList;
   // private List<Folder> folderList = new ArrayList<Folder>();
    public FolderUpdaterService(List<Folder> folderList) {
        this.folderList = folderList;
    }


    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (;;){
                    try {
                        Thread.sleep(5000);
                        //for (Folder folder: folderList){
                        //    if(folder.getType() != Folder.HOLDS_FOLDERS && folder.isOpen()){
                       //        folder.getMessageCount();
                       //    }
                       // }

                        // In other cases -> java.util.concurrentmodificationexception
                        for( int i = 0; i < folderList.size(); i++ )
                        {
                            Folder folder = folderList.get( i );
                            if(folder.getType() != Folder.HOLDS_FOLDERS && folder.isOpen()){
                                folder.getMessageCount();
                            }
                        }
//                        for (Iterator<Folder> iterator = folderList.iterator(); iterator.hasNext();) {
//                            Folder folder = iterator.next();
//                            if(folder.getType() != Folder.HOLDS_FOLDERS && folder.isOpen())
//                                folder.getMessageCount();
//                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}