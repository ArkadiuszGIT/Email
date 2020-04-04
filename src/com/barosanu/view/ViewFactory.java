package com.barosanu.view;

import com.barosanu.EmailManager;
import com.barosanu.controller.BaseController;
import com.barosanu.controller.LoginWindowController;
import com.barosanu.controller.MainWindowController;
import com.barosanu.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Arek on 02.04.2020.
 */
public class ViewFactory {

    private EmailManager emailManager;
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow(){
        System.out.println("show login window");

        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("show Main window");

        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initializeStage(controller);
    }

    public void showOptionsWindow(){
        System.out.println("show Options window");

        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
    }


}
