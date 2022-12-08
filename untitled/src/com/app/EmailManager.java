package com.app;

import com.app.model.EmailAccount;
import javafx.scene.control.TreeItem;

public class EmailManager {

    //Folder handling
    private TreeItem<String> foldersRoot = new TreeItem<String>("");//root for tree view

    public TreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        TreeItem<String> treeItem = new TreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        foldersRoot.getChildren().add(treeItem);//add to the folder root

    }
}
