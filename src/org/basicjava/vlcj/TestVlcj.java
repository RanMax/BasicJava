package org.basicjava.vlcj;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;

/**
 * User: Maxim
 * Date: 17.10.13
 * Time: 20:40
 */
public class TestVlcj {
    public static void main(String[] args){
        JFrame frame = new JFrame("vlcj Tutorial");
        frame.setLocation(100, 100);
        frame.setSize(1050, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NativeLibrary.addSearchPath("libvlc", "C:/Program Files/VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);


        frame.setVisible(true);
        mediaPlayerComponent.getMediaPlayer().playMedia("F:\\04_2_Video\\03_アニメ\\Евангелион (1995) [ТВ] (пер. MC Ent.) [Remastered]\\Evangelion_[01_of_26]_[ru_jp]_[torrents_ru].mkv");
    }
}
