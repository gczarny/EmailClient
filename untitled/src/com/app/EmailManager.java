package com.app;

import com.app.controller.services.FetchFolderService;
import com.app.controller.services.FolderUpdaterService;
import com.app.model.EmailAccount;
import com.app.model.EmailTreeItem;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailManager {

    private FolderUpdaterService folderUpdaterService;
    //Folder handling
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");//root for tree view

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    private List<Folder> folderList = new ArrayList<Folder>();
    public List<Folder> getFolderList(){
        return this.folderList;
    }

    public EmailManager() {
        folderUpdaterService = new FolderUpdaterService(folderList);
        folderUpdaterService.start();
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), treeItem, folderList);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);//add to the folder root
    }
}
