package com.barosanu.model;

import javafx.scene.control.TreeItem;

/**
 * Created by Arek on 06.04.2020.
 */
public class EmailTreeItem<String> extends TreeItem<String> {

    private String name;

    public EmailTreeItem(String name) {
        super(name);
        this.name = name;
    }
}
