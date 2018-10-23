package org.aijiao.wisdom.aibums;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    FlowPane flowPane;

    private static List<String> fileList = new ArrayList(); // 当前文件集合

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
        scanFolder(chosenDir.toString());
        System.out.println("共扫描到" + fileList.size() + "张照片");
        //加载照片
        ImageView imageView = null;
        Image localImage = null;
        for (int i = 0; i < fileList.size(); i++) {
            File file = new File(fileList.get(i));
            String localUrl = file.toURI().toString();
            localImage = new Image(localUrl, false);
            imageView = new ImageView(localImage);
            imageView.setImage(localImage);
            imageView.setFitHeight(120);
            imageView.setFitWidth(120);
            System.out.println("加载第" + i + "张照片");
            flowPane.getChildren().addAll(imageView);
        }
    }

    /**
     * 扫描文件夹，获取所有需要处理的文件
     */
    private void scanFolder(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) {
                String path = file.getAbsolutePath() + "\\" + fileList[i];
                scanFolder(path);
            }
        } else {
            if (file.getAbsolutePath().contains(".jpg") || file.getAbsolutePath().contains(".png")) {
                System.out.println("扫描到的文件：" + file);
                fileList.add(file.getPath());
            }
        }
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


}