package org.aijiao.wisdom.aibums;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    FlowPane flowPane;

    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * 打开照片
     */
    public void shouImage() {
//        File file = new File("F:\\应用宝照片备份\\IMG_20170408_160221.jpg");
//        String localUrl = file.toURI().toString();
//        Image localImage = new Image(localUrl, false);
//        ImageView imageView = new ImageView(localImage);
//        imageView.setImage(localImage);
//        imageView.setFitHeight(120);
//        imageView.setFitWidth(120);
//        flowPane.getChildren().addAll(imageView);
        handleOpenImportFile();
    }

    public void handleOpenImportFile() {
        DirectoryChooser dc = new DirectoryChooser();
        File chosenDir = dc.showDialog(flowPane.getScene().getWindow());
        if (chosenDir == null) {
            System.out.println("目录不能为空！");
        }
        System.out.println("路径：" + chosenDir);
    }

    /**
     * 打开目录
     */
    public void openFolder() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
//        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.showOpenDialog(flowPane.getScene().getWindow());
    }

    // 打开导入窗口
    // TODO: 2017/5/22
    public void openDialogImport(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        File chosenDir = fileChooser.showOpenDialog(flowPane.getScene().getWindow());
    }

}