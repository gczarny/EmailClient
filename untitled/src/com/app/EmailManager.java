package com.app;

import com.app.controller.services.FetchFolderService;
import com.app.model.EmailAccount;
import com.app.model.EmailTreeItem;

public class EmailManager {

    //Folder handling
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");//root for tree view

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), treeItem);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);//add to the folder root

    }
}
