/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Naveen
 */
public class BrowseImage {

    private static BrowseImage browseImage;
    private JFileChooser jf;
    private FileNameExtensionFilter fileNameExtensionFilter;

    private BrowseImage() {
        if (jf == null) {
            jf = new JFileChooser();
        }
        if (fileNameExtensionFilter == null) {
            fileNameExtensionFilter = new FileNameExtensionFilter("JPG and PNG", "jpg", "png", "JPG", "PNG");
        }
    }

    public static BrowseImage getInstance() {
        if (browseImage == null) {
            browseImage = new BrowseImage();
        }
        return browseImage;
    }

    public String browse(JLabel picComponent) {
        String picturePath = "";
        jf.setFileFilter(fileNameExtensionFilter);
        jf.showOpenDialog(null);
        if (!(jf.getSelectedFile() == null)) {
            File f = jf.getSelectedFile();
            String path = f.getAbsolutePath().replace("\\", "/");
            if (path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".JPG") || path.endsWith(".PNG")) {
                picturePath = path;
                setPicture(picturePath, picComponent);
            } else {
                response.Response.error("<html>File type you selected isn't siutable for a image....<br><center><b><font color=blue>Please select a file with the extension of .jpg or .png</html>");
            }
        }
        return picturePath;
    }

    void setPicture(String picturePath, JLabel picComponent) {
        try {
            if (picturePath != null) {
                File MyFile = new File(picturePath);
                Image img = ImageIO.read(MyFile);
                img = img.getScaledInstance(picComponent.getWidth(), picComponent.getHeight(), Image.SCALE_SMOOTH);
                picComponent.setIcon(new ImageIcon(img));
            } else {
                response.Response.error("Please select the picture again! :-D");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
